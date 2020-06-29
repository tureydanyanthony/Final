package fnl;


public interface FileBo {
	public String[] viewFiles();
	public void addFiles(String filename);
	public void deleteFiles(String filename);
	public boolean searchFiles(String filename);

}
