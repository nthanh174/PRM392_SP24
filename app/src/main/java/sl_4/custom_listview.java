package sl_4;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.code.R;

import java.util.ArrayList;
import java.util.List;

public class custom_listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_listview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ListView listView = findViewById(R.id.listView);

        List<User> userList = new ArrayList<>();
        userList.add(new User("John Doe", "john@example.com", R.drawable.ic_launcher_background));
        userList.add(new User("Jane Smith", "jane@example.com", R.drawable.ic_launcher_background));
        userList.add(new User("Sam Wilson", "sam@example.com", R.drawable.ic_launcher_background));

        UserAdapter adapter = new UserAdapter(this, userList);
        listView.setAdapter(adapter);
    }
}