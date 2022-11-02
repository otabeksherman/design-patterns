package Exercise3;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class ExportToJsonVisitor implements Visitor {

    private Gson gson = new Gson();

    @Override
    public void visit(User user) {
        String path = String.valueOf(user.getId());
        try(FileWriter writer = new FileWriter(path)) {
            gson.toJson(user, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void visit(Asset asset) {
        String path = String.valueOf(asset.getSerialNumber());
        try(FileWriter writer = new FileWriter(path)) {
            gson.toJson(asset, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void visit(Group group) {
        String path = String.valueOf(group.getId());
        try(FileWriter writer = new FileWriter(path)) {
            gson.toJson(group, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
