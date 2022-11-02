package Exercise3;

public interface Visitor {
    void visit(User user);
    void visit(Asset asset);
    void visit(Group group);
}
