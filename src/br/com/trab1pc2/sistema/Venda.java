package br.com.trab1pc2.sistema;
import br.com.trab1pc2.produto.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Venda {
	private long id; // (Auto gerado)
	private Date data;
	private Pedido pedido;
	private String cliente;
	
	private static long geraId=1;
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	private Venda(Pedido pedido, String cliente, Date data) {
		this.id = geraId;
		geraId++;
		
		this.pedido = pedido;
		this.cliente = cliente;
		this.data = data;
	}
	
	public static Venda getInstance(Pedido pedido, String cliente, String data) {
		if (pedido != null && (cliente != null && cliente.length() >= 2) && (data != null && (data.length() >= 8 && data.length() <= 10))) {
			Date dataFormatada = null;
			try {
				dataFormatada = formato.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			return new Venda(pedido, cliente, dataFormatada);
		} else {
			return null;
		}
	}
	
	
	// Getters and Setters
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}
	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

}
