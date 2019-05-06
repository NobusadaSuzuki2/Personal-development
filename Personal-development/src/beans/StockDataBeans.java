package beans;

import java.io.Serializable;

/**
 * 在庫数
 */
public class StockDataBeans implements Serializable {

	private int id;
	private int stock;
	private int itemId;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


}
