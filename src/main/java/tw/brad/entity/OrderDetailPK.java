package tw.brad.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailPK implements Serializable{
	private Integer orderId;
	private Integer productId;
	
	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof OrderDetailPK)) return false;
		OrderDetailPK other = (OrderDetailPK)obj;
		return orderId == other.orderId && productId == other.productId;
	}
	
}
