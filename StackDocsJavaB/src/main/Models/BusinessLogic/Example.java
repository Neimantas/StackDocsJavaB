package main.Models.BusinessLogic;

public class Example {
	private long _id;
	private long _docTopicId;
	private String _title;
	private String _bodyHTML;
	private String _bodyMarkdown;


	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getDocTopicId() {
		return _docTopicId;
	}

	public void setDocTopicId(long docTopicId) {
		 _docTopicId = docTopicId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getBodyHTML() {
		return _bodyHTML;
	}

	public void setBodyHTML(String bodyHTML) {
		_bodyHTML = bodyHTML;
	}

	public String getBodyMarkdown() {
		return _bodyMarkdown;
	}

	public void setBodyMarkdown(String bodyMarkdown) {
		_bodyMarkdown = bodyMarkdown;
	}
}
