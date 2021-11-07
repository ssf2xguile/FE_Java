import java.util.UUID;

public class ToDo {
    public enum Priority {LOW, MIDDLE, HIGH}
    public enum State {NOT_YET_STARTED, STARTED, DONE}
    
    //8桁または12桁の数字から成る文字列と一致する正規表現
    private static final String DEADLINE_PATTERN = "\\d{8}|\\d{12}";

    private final String id;
    private String subject;
    private String deadline;
    private Priority priority;
    private State state;

    private ToDo(String subject, String deadline, Priority priority, String id, State state){
        if(!deadline.matches(DEADLINE_PATTERN)){
            throw new IllegalArgumentException();
        }
        this.subject = subject;
        this.deadline = deadline;
        this.priority = priority;
        this.id = id;
        this.state = state;
    }

    public ToDo(String subject, String deadline, Priority priority){
        this(subject, deadline, priority, UUID.randomUUID().toString(), State.NOT_YET_STARTED);
    }

    public ToDo(ToDo todo) {
        this(todo.subject, todo.deadline, todo.priority, todo.id, todo.state);
    }

    public String getSubject(){return subject;}
    public String getDeadline(){return deadline;}
    public Priority getPriority(){return priority;}
    public State getState(){return state;}
    public void setState(State state){this.state = state;}
    public int hashCode(){return id.hashCode();}
    public boolean equals(Object o){
        return o instanceof ToDo &&((ToDo) o).id.equals(id);
    }

    public String toString(){
        return String.format("主題: %s, 期限: %s, 優先度: %s, 状態: %s", subject, deadline, priority, state);
    }
}
