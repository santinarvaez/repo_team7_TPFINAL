package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTS")
public class Product {
	
		@Id
		@Column(name="pro_code")
		private String productCode;
		
		@NotEmpty(message = "Introduzca un nombre de producto")
		@Column(name="pro_name")
		private String productName;
		
		@NotNull
		@Column(name="pro_scale")
		private String productScale;
		
		@NotEmpty(message = "Ingrese la empresa proveedora del producto")
		@Column(name="pro_vendor")
		private String productVend;
		
		@NotEmpty(message = "Ingrese una descripción")
		@Column(name="pro_des",length = 9000)
		private String description;
		
		@NotNull(message = "Ingrese stock del producto")
		@Column(name="pro_stock")
		private int stock;
		
		@NotNull
		@Column(name="pro_price")
		private float buyPrice;
		
		@Column(name="pro_MSRP")
		private float MSRP;
		
		@Autowired
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="productLine")
		private ProductLine productLine;
		
		
		
		//CONSTRUCTORES
		
		public Product() {
			// TODO Auto-generated constructor stub
		}
		
		
		public Product(String productCode, @NotEmpty(message = "Introduzca un nombre de producto") String productName,
				@NotNull String productScale,
				@NotEmpty(message = "Ingrese la empresa proveedora del producto") String productVend,
				@NotEmpty(message = "Ingrese una descripción") String description,
				@NotNull(message = "Ingrese stock del producto") int stock, @NotNull float buyPrice, float mSRP,
				ProductLine productLine) {
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



		//GETTERS & SETTERS

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

		public String getProductScale() {
			return productScale;
		}

		public void setProductScale(String productScale) {
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
