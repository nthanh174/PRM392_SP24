package sl_6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.code.R;

import java.util.List;

public class FormUser extends AppCompatActivity {

    private UserDAO userDAO;
    private ListView listView;
    private UserAdapter userAdapter;
    private EditText etUserId, etUserName, etUserEmail, etImageUrl;
    private Button btnAdd, btnUpdate, btnDelete, btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

        userDAO = new UserDAO(this);
        userDAO.open();

        listView = findViewById(R.id.listView);
        etUserId = findViewById(R.id.etUserId);
        etUserName = findViewById(R.id.etUserName);
        etUserEmail = findViewById(R.id.etUserEmail);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnDisplay = findViewById(R.id.btnDisplay);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser();
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayUsers();
            }
        });
    }

    private void addUser() {
        String name = etUserName.getText().toString();
        String email = etUserEmail.getText().toString();
        int defaultImageUrl = R.drawable.ic_launcher_background;

        User user = new User(name, email, defaultImageUrl);
        userDAO.addUser(user);

        Toast.makeText(this, "User Added", Toast.LENGTH_SHORT).show();
    }

    private void updateUser() {
        int id = Integer.parseInt(etUserId.getText().toString());
        String name = etUserName.getText().toString();
        String email = etUserEmail.getText().toString();
        int defaultImageUrl = R.drawable.ic_launcher_background;

        User user = new User(id, name, email, defaultImageUrl);
        userDAO.updateUser(user);

        Toast.makeText(this, "User Updated", Toast.LENGTH_SHORT).show();
    }

    private void deleteUser() {
        int id = Integer.parseInt(etUserId.getText().toString());
        User user = new User(id, "", "", 0);
        userDAO.deleteUser(user);

        Toast.makeText(this, "User Deleted", Toast.LENGTH_SHORT).show();
    }


    private void displayUsers() {
        List<User> users = userDAO.getAllUsers();

        if (users != null && !users.isEmpty()) {
            if (userAdapter == null) {
                userAdapter = new UserAdapter(this, users);
                listView.setAdapter(userAdapter);
            } else {
                userAdapter.clear();
                userAdapter.addAll(users);
                userAdapter.notifyDataSetChanged();
            }
        } else {
            Toast.makeText(this, "No users found", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onDestroy() {
        userDAO.close();
        super.onDestroy();
    }
}
