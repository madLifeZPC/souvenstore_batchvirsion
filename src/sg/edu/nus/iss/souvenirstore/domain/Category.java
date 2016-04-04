package sg.edu.nus.iss.souvenirstore.domain;

import java.util.ArrayList;

import sg.edu.nus.iss.souvenirstore.service.ProductService;
import sg.edu.nus.iss.souvenirstore.service.VendorService;

/**
 * 
 * @author Zhao PengCheng
 *
 */
public class Category {

		private String categoryId;
		private String categoryName;
		private ArrayList<Product> products;
		private ArrayList<Vendor> vendors;
		
		public Category()
		{
			
		}
		
		public Category(String categoryId, String categoryName) {
			super();
			this.categoryId = categoryId;
			this.categoryName = categoryName;
		}
		
		public String getCategoryId() {
			return categoryId;
		}
		
		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}
		
		public String getCategoryName() {
			return categoryName;
		}
		
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		
		public ArrayList<Product> getProducts()
		{
			this.products = new ArrayList<>();
			if( this.categoryId != null )
			{
				try 
				{
					ArrayList<Product> productList = ProductService.getProductService().getProductList();
					for( Product product : productList )
					{
						if( product.getProductId().startsWith(this.categoryId) )
						{
							products.add(product);
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			return products;
		}
		
		public void setProducts( ArrayList<Product> products )
		{
			this.products = products;
		}
		
		public ArrayList<Vendor> getVendors()
		{
			this.vendors = new ArrayList<>();
			if( this.categoryId != null )
			{
				try 
				{
					this.vendors = VendorService.getVendorService().getVendorList(categoryId);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			return vendors;
		}
		
		public void setVendors( ArrayList<Vendor> vendors )
		{
			this.vendors = vendors;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
			result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Category other = (Category) obj;
			if (categoryId == null) {
				if (other.categoryId != null)
					return false;
			} else if (!categoryId.equals(other.categoryId))
				return false;
			if (categoryName == null) {
				if (other.categoryName != null)
					return false;
			} else if (!categoryName.equals(other.categoryName))
				return false;
			return true;
		}
		
		
}
