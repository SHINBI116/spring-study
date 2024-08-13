package com.ezen.springdata.fruit.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class FruitsSalesHistoryInfoDTO {
	private Integer fid;
	private Integer fhid;
	private Integer purchase_qty;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date purchase_time;
	private String fname;
	private Integer price;
	private Integer remain_qty;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date exp_date;
	private Integer location_id;
}
