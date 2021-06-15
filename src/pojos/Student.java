package pojos;

public class Student {
	private String id;
	private String name;
	private String base64Image;
	private byte[] image;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}

	public Student(String id, String name, String base64Image) {
		super();
		this.id = id;
		this.name = name;
		this.base64Image = base64Image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
