package br.com.trab1pc2.sistema;
import br.com.trab1pc2.produto.*;

import java.util.Calendar;

public class Venda {
	private long id; // (Auto gerado)
	private Calendar data;
	private Pedido pedido;
	private String cliente;
	
	private static long geraId=1;
	
	
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
	public Calendar getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Calendar data) {
		this.data = data;
	}
	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}
	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}
