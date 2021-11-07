public class ToDoListTester {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        list.add(new ToDo("メール送信", "201604181500", ToDo.Priority.HIGH));
        list.add(new ToDo("ホテル予約", "20160420", ToDo.Priority.LOW));
        list.add(new ToDo("チケット購入", "20160430", ToDo.Priority.MIDDLE));
        list.add(new ToDo("報告書作成", "20160428", ToDo.Priority.HIGH));
        list.add(new ToDo("会議室予約", "201605301200", ToDo.Priority.HIGH));
        list.update(new ToDo("PC購入", "20160531", ToDo.Priority.HIGH));
        for(ToDo todo: list.select()){
            todo.setState(ToDo.State.STARTED);
            list.update(todo);
        }
        Condition condition1 = new Condition(){
            public boolean test(ToDo todo){
                return todo.getDeadline().compareTo("20160501")<0;
            }
        };
        Condition condition2 = new Condition(){
            public boolean test(ToDo todo){
                return todo.getPriority().equals(ToDo.Priority.HIGH);
            }
        };
        for(ToDo todo: list.select(condition1, condition2)){
            System.out.println(todo);
        }
    }
}
