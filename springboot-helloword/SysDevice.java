package com.demo.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_device")
public class SysDevice  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "H_ID")
	private Long hId;

	@Column(name = "D_CODENUM")
	private String dCodenum;

	@Column(name = "D_NAME")
	private String dName;

	@Column(name = "D_TYPE")
	private Long dType;

	@Column(name = "D_STATUS")
	private Long dStatus;

	@Column(name = "D_CREATETIME")
	private java.util.Date dCreatetime;

	@Column(name = "D_UPDATETIME")
	private java.util.Date dUpdatetime;

	@Column(name = "D_LASTSYNCTIME")
	private java.util.Date dLastsynctime;

}
