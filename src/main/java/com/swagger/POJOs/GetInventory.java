package com.swagger.POJOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sold", "placed", "aviable", "string", "unavailable", "available", "PENDING", "na", "free", "OK",
		"Not available" })
public class GetInventory {

	@JsonProperty("sold")
	private Integer sold;
	@JsonProperty("placed")
	private Integer placed;
	@JsonProperty("aviable")
	private Integer aviable;
	@JsonProperty("string")
	private Integer string;
	@JsonProperty("unavailable")
	private Integer unavailable;
	@JsonProperty("available")
	private Integer available;
	@JsonProperty("PENDING")
	private Integer pending;
	@JsonProperty("na")
	private Integer na;
	@JsonProperty("free")
	private Integer free;
	@JsonProperty("OK")
	private Integer ok;
	@JsonProperty("Not available")
	private Integer notAvailable;

	@JsonProperty("sold")
	public Integer getSold() {
		return sold;
	}

	@JsonProperty("sold")
	public void setSold(Integer sold) {
		this.sold = sold;
	}

	@JsonProperty("placed")
	public Integer getPlaced() {
		return placed;
	}

	@JsonProperty("placed")
	public void setPlaced(Integer placed) {
		this.placed = placed;
	}

	@JsonProperty("aviable")
	public Integer getAviable() {
		return aviable;
	}

	@JsonProperty("aviable")
	public void setAviable(Integer aviable) {
		this.aviable = aviable;
	}

	@JsonProperty("string")
	public Integer getString() {
		return string;
	}

	@JsonProperty("string")
	public void setString(Integer string) {
		this.string = string;
	}

	@JsonProperty("unavailable")
	public Integer getUnavailable() {
		return unavailable;
	}

	@JsonProperty("unavailable")
	public void setUnavailable(Integer unavailable) {
		this.unavailable = unavailable;
	}

	@JsonProperty("available")
	public Integer getAvailable() {
		return available;
	}

	@JsonProperty("available")
	public void setAvailable(Integer available) {
		this.available = available;
	}

	@JsonProperty("PENDING")
	public Integer getPending() {
		return pending;
	}

	@JsonProperty("PENDING")
	public void setPending(Integer pending) {
		this.pending = pending;
	}

	@JsonProperty("na")
	public Integer getNa() {
		return na;
	}

	@JsonProperty("na")
	public void setNa(Integer na) {
		this.na = na;
	}

	@JsonProperty("free")
	public Integer getFree() {
		return free;
	}

	@JsonProperty("free")
	public void setFree(Integer free) {
		this.free = free;
	}

	@JsonProperty("OK")
	public Integer getOk() {
		return ok;
	}

	@JsonProperty("OK")
	public void setOk(Integer ok) {
		this.ok = ok;
	}

	@JsonProperty("Not available")
	public Integer getNotAvailable() {
		return notAvailable;
	}

	@JsonProperty("Not available")
	public void setNotAvailable(Integer notAvailable) {
		this.notAvailable = notAvailable;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(GetInventory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("sold");
		sb.append('=');
		sb.append(((this.sold == null) ? "<null>" : this.sold));
		sb.append(',');
		sb.append("placed");
		sb.append('=');
		sb.append(((this.placed == null) ? "<null>" : this.placed));
		sb.append(',');
		sb.append("aviable");
		sb.append('=');
		sb.append(((this.aviable == null) ? "<null>" : this.aviable));
		sb.append(',');
		sb.append("string");
		sb.append('=');
		sb.append(((this.string == null) ? "<null>" : this.string));
		sb.append(',');
		sb.append("unavailable");
		sb.append('=');
		sb.append(((this.unavailable == null) ? "<null>" : this.unavailable));
		sb.append(',');
		sb.append("available");
		sb.append('=');
		sb.append(((this.available == null) ? "<null>" : this.available));
		sb.append(',');
		sb.append("pending");
		sb.append('=');
		sb.append(((this.pending == null) ? "<null>" : this.pending));
		sb.append(',');
		sb.append("na");
		sb.append('=');
		sb.append(((this.na == null) ? "<null>" : this.na));
		sb.append(',');
		sb.append("free");
		sb.append('=');
		sb.append(((this.free == null) ? "<null>" : this.free));
		sb.append(',');
		sb.append("ok");
		sb.append('=');
		sb.append(((this.ok == null) ? "<null>" : this.ok));
		sb.append(',');
		sb.append("notAvailable");
		sb.append('=');
		sb.append(((this.notAvailable == null) ? "<null>" : this.notAvailable));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}