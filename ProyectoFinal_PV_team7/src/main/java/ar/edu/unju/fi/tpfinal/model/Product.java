package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTS")
public class Product {
	
		@Id
		@Column(name="pro_code")
		private String productCode;
		
		@Column(name="pro_name")
		private String productName;
		
		@Column(name="pro_scale")
		private LocalDate productScale;
		
		@Column(name="pro_vendor")
		private String productVend;
		
		@Column(name="pro_des")
		private String description;
		
		@Column(name="pro_stock")
		private int stock;
		
		@Column(name="pro_price")
		private float buyPrice;
		
		@Column(name="pro_MSRP")
		private float MSRP;
		
		@Autowired
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="productLine")
		private ProductLine productLine;
		
		/*@OneToMany
		@OneToMany(mappedBy = "id.")
		private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();*/
		
		public Product() {
			// TODO Auto-generated constructor stub
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
		

		
		
}
