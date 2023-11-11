public class Data {
    String title = "";
    String description = "";
    String button1 = "修改";
    String button2 = "删除";

    public Data(String title, String description, String button1, String button2) {
        this.title = title;
        this.description = description;
        this.button1 = button1;
        this.button2 = button2;
    }

    public Data(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
