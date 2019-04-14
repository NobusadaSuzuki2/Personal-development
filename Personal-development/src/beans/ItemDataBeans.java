package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * アイテム
 * @author d-yamaguchi
 *
 */
public class ItemDataBeans implements Serializable {
	private int id;
	private String name;
	private String detail;
	private int price;
	private String fileName;
	private Date createDate;
	private Date updateDate;


	public ItemDataBeans(int id, String name, String detail, int price, String fileName, Date createDate,
			Date updateDate) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public ItemDataBeans() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public int getId() {
		return id;
	}
	public void setId(int itemId) {
		this.id = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String itemName) {
		this.name = itemName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int itemPrice) {
		this.price = itemPrice;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String filename) {
		this.fileName = filename;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getFormatCreateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(createDate);
	}
	public String getFormatUpdateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(updateDate);
	}



}
