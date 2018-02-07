package com.orange.onapbss.resources.productorder;

import com.orange.onapbss.datamodel.productordering.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, String> {

}
