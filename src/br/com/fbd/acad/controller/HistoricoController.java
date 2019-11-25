package br.com.fbd.acad.controller;

import java.io.InputStream;
import java.util.List;

import br.com.fbd.acad.entidade.Venda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class HistoricoController {
	
public void gerarHistorico(List<Venda> venda) {
		
		try {
			InputStream fonte = ReciboController.class.getResourceAsStream("/br/com/fbd/acad/report/historico.jrxml");
			JasperReport report = JasperCompileManager.compileReport(fonte);
			JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(venda));
			JasperViewer.viewReport(print, false);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
