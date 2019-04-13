package com.demo.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_order")
public class SysOrder  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "OD_NUMBER")
	private String odNumber;

	@Column(name = "U_ID")
	private Long uId;

	@Column(name = "O_ID")
	private Long oId;

	@Column(name = "OD_ORGANIZATION")
	private Long odOrganization;

	@Column(name = "F_O_ID")
	private Long fOId;

	@Column(name = "OD_F_ORGANIZATION")
	private Long odFOrganization;

	@Column(name = "OD_TYPE")
	private Long odType;

	@Column(name = "OD_STATUS")
	private Long odStatus;

	@Column(name = "OD_CHECK")
	private Long odCheck;

	@Column(name = "OD_CHECK_WZ")
	private Long odCheckWz;

	@Column(name = "OD_ABSTRACT")
	private String odAbstract;

	@Column(name = "OD_CREATETIME")
	private java.util.Date odCreatetime;

	@Column(name = "INPATIENT_NO")
	private String inpatientNo;

	@Column(name = "PATIENT_ID")
	private String patientId;

	@Column(name = "VISIT_NUM")
	private String visitNum;

	@Column(name = "PATIENT_NAME")
	private String patientName;

	@Column(name = "PATIENT_SEX")
	private Long patientSex;

	@Column(name = "PATIENT_AGE")
	private Long patientAge;

	@Column(name = "PATIENT_BIRTHDAY")
	private java.util.Date patientBirthday;

	@Column(name = "PATIENT_IDENTIFICATION")
	private String patientIdentification;

	@Column(name = "PATIENT_DEPT_NAME")
	private String patientDeptName;

	@Column(name = "PATIENT_DEPT_CODE")
	private String patientDeptCode;

	@Column(name = "OPS_NO")
	private String opsNo;

	@Column(name = "OPS_NAME")
	private String opsName;

	@Column(name = "OPS_DOC_ID")
	private String opsDocId;

	@Column(name = "OPS_DOC_NAME")
	private String opsDocName;

	@Column(name = "OPS_NUR_ID")
	private String opsNurId;

	@Column(name = "OPS_NUR_NAME")
	private String opsNurName;

	@Column(name = "OPS_DATE")
	private java.util.Date opsDate;

	@Column(name = "OPER_DOC_ID")
	private String operDocId;

	@Column(name = "OPER_DOC_NAME")
	private String operDocName;

	@Column(name = "EXEC_DEPT_CODE")
	private String execDeptCode;

	@Column(name = "EXEC_DEPT_NAME")
	private String execDeptName;

	@Column(name = "OD_ISSETTLED")
	private Long odIssettled;

	@Column(name = "OD_SETTLEDTIME")
	private java.util.Date odSettledtime;

	@Column(name = "OD_SETTLED_UID")
	private Long odSettledUid;

	@Column(name = "OD_ISREFUND")
	private Long odIsrefund;

}
