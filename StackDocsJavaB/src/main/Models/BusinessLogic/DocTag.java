package Models.BusinessLogic;

public class DocTag {
	private long _id;
	private String _tag;
	private String _title;

	public long getId() {
		return _id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return "ID: " + _id + " || Tag: " + _tag + " || Title: " + _title;
	}
}
