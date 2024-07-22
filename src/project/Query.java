package project;

public class Query {
    static String insert = "insert into record (id, name, email) values (?,?,?)";
    static String select = "select * from record";
    static  String update = "update record set name=?, email=? where id=?";
    static String delete = "delete from record where id=?";
}
