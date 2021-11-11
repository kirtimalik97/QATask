package com.swagger.POJOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "category", "name", "photoUrls", "tags", "status" })
public class PetData {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("category")
	private Category category;
	@JsonProperty("name")
	private String name;
	@JsonProperty("photoUrls")
	private List<String> photoUrls = null;
	@JsonProperty("tags")
	private List<Tag> tags = null;
	@JsonProperty("status")
	private String status;

	@JsonProperty("id")
	public Integer getId() {
		return (Integer) id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("category")
	public Category getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(Category category) {
		this.category = category;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("photoUrls")
	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	@JsonProperty("photoUrls")
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	@JsonProperty("tags")
	public List<Tag> getTags() {
		return tags;
	}

	@JsonProperty("tags")
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Object status) {
		this.status = String.valueOf(status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("category");
		sb.append('=');
		sb.append(((this.category == null) ? "<null>" : this.category));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("photoUrls");
		sb.append('=');
		sb.append(((this.photoUrls == null) ? "<null>" : this.photoUrls));
		sb.append(',');
		sb.append("tags");
		sb.append('=');
		sb.append(((this.tags == null) ? "<null>" : this.tags));
		sb.append(',');
		sb.append("status");
		sb.append('=');
		sb.append(((this.status == null) ? "<null>" : this.status));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}