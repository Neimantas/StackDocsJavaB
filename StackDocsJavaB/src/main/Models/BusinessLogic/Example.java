package main.Models.BusinessLogic;

public class Example {
	private int _id;
	private int _docTopicId;
	private String _tytle;

	private String _bodyHTML;
	private String _bodyMarkdown;

	public Example(int id, int docTopicId, String tytle, String bodyHTML, String bodyMarkdown) {
		_id = id;
		_docTopicId = docTopicId;
		_tytle = tytle;
		_bodyHTML = bodyHTML;
		_bodyMarkdown = bodyMarkdown;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public int getDocTopicId() {
		return _docTopicId;
	}

	public void setDocTopicId(int docTopicId) {
		 _docTopicId = docTopicId;
	}

	public String getTytle() {
		return _tytle;
	}

	public void setTytle(String tytle) {
		_tytle = tytle;
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
