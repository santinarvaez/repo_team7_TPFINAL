package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;
//import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTS")
public class Product {
	
		@Id
		@Column(name="pro_Code")
		private String productCode;
		
		@Column(name="pro_Name")
		private String productName;
		
		@Column(name="pro_Scale")
		private LocalDate productScale;
		
		@Column(name="pro_Vendor")
		private String productVend;
		
		@Column(name="pro_Des")
		private String description;
		
		@Column(name="pro_Stock")
		private int stock;
		
		@Column(name="pro_Stock")
		private float buyPrice;
		
		@Column(name="pro_MSRP")
		private float MSRP;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="productLine")
		private ProductLine productLine;

		
		public Product() {
			// TODO Auto-generated constructor stub
		}
		
		
		public Product(String productCode, String productName, LocalDate productScale, String productVend,
				String description, int stock, float buyPrice, float mSRP, ProductLine productLine) {
			super();
			this.productCode = productCode;
			this.productName = productName;
			this.productScale = productScale;
			this.productVend = productVend;
			this.description = description;
			this.stock = stock;
			this.buyPrice = buyPrice;
			MSRP = mSRP;
			this.productLine = productLine;
		}


		public String getProductCode() {
			return productCode;
		}

		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public LocalDate getProductScale() {
			return productScale;
		}

		public void setProductScale(LocalDate productScale) {
			this.productScale = productScale;
		}

		public String getProductVend() {
			return productVend;
		}

		public void setProductVend(String productVend) {
			this.productVend = productVend;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public float getBuyPrice() {
			return buyPrice;
		}

		public void setBuyPrice(float buyPrice) {
			this.buyPrice = buyPrice;
		}

		public float getMSRP() {
			return MSRP;
		}

		public void setMSRP(float mSRP) {
			MSRP = mSRP;
		}

		public ProductLine getProductLine() {
			return productLine;
		}

		public void setProductLine(ProductLine productLine) {
			this.productLine = productLine;
		}


		
		
		//private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		
		
}
