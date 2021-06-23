package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTSLINES")
public class ProductLine {

	@Id
	@NotEmpty
	@Column(name = "productLine", length = 50)
	private String id;
	
	@NotEmpty(message = "Ingrese una descripción")
	@Column(name = "textDescription", length = 4000)
	private String textDescription;
	
	@Column(name = "htmlDescription")
	private String htmlDescription;
	
	@Lob
	@Column(name = "img", length=100000)
	private byte[] imagen;
	
	@OneToMany(mappedBy = "productLine")
	private List<Product> productos = new ArrayList<Product>();
	
	//CONSTRUCTORES
	
	public ProductLine() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductLine(@NotEmpty String id, @NotEmpty(message = "Ingrese una descripción") String textDescription,
			String htmlDescription, byte[] imagen, List<Product> productos) {
		super();
		this.id = id;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.imagen = imagen;
		this.productos = productos;
	}


	//GETTERS & SETTERS
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}
	
	
	
}
