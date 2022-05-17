package dia29.apiproduct.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dia29.apiproduct.model.Bill;
import dia29.apiproduct.model.BillDetails;
import dia29.apiproduct.reportes.VentasExcelReport;
import dia29.apiproduct.reportes.VentasPdfReport;
import dia29.apiproduct.service.IBillDetailsService;
import dia29.apiproduct.service.IBillService;



@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	private IBillDetailsService bdS;
	
	@Autowired
	private IBillService bS;
 	
	
	@GetMapping("/billNumber/{billnumber}")
	public ResponseEntity<List<BillDetails>> getAllByBillNumber(@PathVariable("billnumber") long billN){
		return ResponseEntity.ok().body(bdS.getAllByBillNumber(billN));
	}
	
	@GetMapping("/clientId/{clientId}")
	public ResponseEntity<List<BillDetails>> getAllByClientId(@PathVariable("clientId") long id){
		return ResponseEntity.ok().body(bdS.getAllByClientId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> createBill(@RequestBody Bill bill){
		if(bS.save(bill))
			return ResponseEntity.ok().body("Bill created");
		else
			return ResponseEntity.badRequest().body("Bad Request pa");
	}
	
	@PostMapping("/billDetails")
	public ResponseEntity<?> createBill(@RequestBody BillDetails bill){
		if(bdS.save(bill))
			return ResponseEntity.ok().body("BillDetails created");
		else
			return ResponseEntity.badRequest().body("Bad Request pa");
	}
	
	@GetMapping("/billReport/pdf/")
	public void reporteVentasPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment;filename=Bill-ListPDF.pdf");
		VentasPdfReport pdf = new VentasPdfReport(bS.getAll(),bdS.getAll());
		pdf.export(response);
	}
	
	@GetMapping("/billReport/excel")
	public void reporteVentasExcell(HttpServletResponse response) throws DocumentException, IOException{
		response.setContentType("application/octet-string");
		response.setHeader("Content-Disposition","attachment;filename=Ventas-Listexcel.xlsx");
		VentasExcelReport exc = new VentasExcelReport(bS.getAll(),bdS.getAll());
		exc.export(response);
	}
	
	
	@GetMapping("/billReportByClient/pdf/{id}")
	public void reporteVentasPDFPorCliente(HttpServletResponse response, @PathVariable("id") long id) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment;filename=Ventas-ListPDF.pdf");
		VentasPdfReport pdf = new VentasPdfReport(bS.getAllByBillNumber(id),bdS.getAllByBillNumber(id));
		pdf.export(response);
	}
	
	@GetMapping("/billReportByClient/excel/{id}")
	public void reporteVentasExcell(HttpServletResponse response,@PathVariable("id") long id) throws DocumentException, IOException{
		response.setContentType("application/octet-string");
		response.setHeader("Content-Disposition","attachment;filename=Ventas-Listexcel.xlsx");
		VentasExcelReport exc = new VentasExcelReport(bS.getAllByBillNumber(id),bdS.getAllByBillNumber(id));
		exc.export(response);
	}  
}
