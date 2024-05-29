package sl_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.code.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {  // View does not exist -> create a new view
            convertView = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false);
            holder = new ViewHolder();
            holder.ivProfile = convertView.findViewById(R.id.ivProfile);
            holder.tvId = convertView.findViewById(R.id.tvId);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvEmail = convertView.findViewById(R.id.tvEmail);
            convertView.setTag(holder);
        } else {  // View exists -> get old view
            holder = (ViewHolder) convertView.getTag();
        }

        User user = userList.get(position);
        holder.tvId.setText(String.valueOf(user.getId()));
        holder.tvName.setText(user.getName());
        holder.tvEmail.setText(user.getEmail());
        // holder.ivProfile.setImageResource(user.getImageUrl());

        return convertView;
    }


    static class ViewHolder {
        ImageView ivProfile;
        TextView tvId;
        TextView tvName;
        TextView tvEmail;
    }

    public void addAll(List<User> users) {
        userList.addAll(users);
        notifyDataSetChanged();
    }

    public void clear() {
        userList.clear();
        notifyDataSetChanged();
    }
}
