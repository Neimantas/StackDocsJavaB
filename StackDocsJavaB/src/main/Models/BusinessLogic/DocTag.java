package Models.BusinessLogic;

public class DocTag {
	private int _id; 
	private String _tag;
	private String _title;

	public DocTag(int id, String tag, String title) {
		_id = id;
		_tag = tag;
		_title = title;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}
}
