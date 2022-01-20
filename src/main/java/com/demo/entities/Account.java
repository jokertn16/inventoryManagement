package com.demo.entities;
// Generated Jan 20, 2022, 9:21:20 AM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", catalog = "qlkh")
public class Account implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private String fullName;
	private byte status;
	private String email;
	private Set<ImportInvoices> importInvoiceses = new HashSet<ImportInvoices>(0);
	private Set<ExportInvoice> exportInvoices = new HashSet<ExportInvoice>(0);
	private Set<Role> roles = new HashSet<Role>(0);

	public Account() {
	}

	public Account(String username, String password, String fullName, byte status, String email) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.email = email;
	}

	public Account(String username, String password, String fullName, byte status, String email,
			Set<ImportInvoices> importInvoiceses, Set<ExportInvoice> exportInvoices, Set<Role> roles) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.email = email;
		this.importInvoiceses = importInvoiceses;
		this.exportInvoices = exportInvoices;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 250)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 250)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "full_name", nullable = false, length = 250)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "status", nullable = false)
	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Column(name = "email", nullable = false, length = 250)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<ImportInvoices> getImportInvoiceses() {
		return this.importInvoiceses;
	}

	public void setImportInvoiceses(Set<ImportInvoices> importInvoiceses) {
		this.importInvoiceses = importInvoiceses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<ExportInvoice> getExportInvoices() {
		return this.exportInvoices;
	}

	public void setExportInvoices(Set<ExportInvoice> exportInvoices) {
		this.exportInvoices = exportInvoices;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "acc_role", catalog = "qlkh", joinColumns = {
			@JoinColumn(name = "id_acc", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_role", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
