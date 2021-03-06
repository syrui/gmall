package com.gmall.module.demo.entity;

import com.gmall.base.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 库存单元表实体类
 * @author by imall core generator
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo implements Serializable {
	public  static final String ID = "id";
	public static final String PRODUCT_ID = "productId";
	public static final String PRICE = "price";
	public static final String SKU_NAME = "skuName";
	public static final String SKU_DESC = "skuDesc";
	public static final String WEIGHT = "weight";
	public static final String TM_ID = "tmId";
	public static final String CATALOG3_ID = "catalog3Id";
	public static final String SKU_DEFAULT_IMG = "skuDefaultImg";
	@TableId
	private Long id;
	/** PRODUCT_ID - 商品id */


	private Long productId;
	/** PRICE - 价格 */

	private Double price;
	/** SKU_NAME - sku名称 */


	private String skuName;
	/** SKU_DESC - 商品规格描述 */


	private String skuDesc;
	/** WEIGHT - 重量 */


	private Double weight;
	/** TM_ID - 品牌(冗余) */


	private Long tmId;
	/** CATALOG3_ID - 三级分类id（冗余) */


	private Long catalog3Id;
	/** SKU_DEFAULT_IMG - 默认显示图片(冗余) */

	private String skuDefaultImg;




}