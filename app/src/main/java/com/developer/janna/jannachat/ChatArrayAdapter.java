package com.developer.janna.jannachat;

/**
 * Created by janna on 21/10/2016.
 */

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import com.example.janna.chat_2.R;import java.text.DateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Locale;

class ChatArrayAdapter extends ArrayAdapter<ChatMessage> {

    private TextView chatText;
    private TextView dateStyle;
    private List<ChatMessage> chatMessageList = new ArrayList<ChatMessage>();
    private Context context;

    @Override
    public void add(ChatMessage object) {
        chatMessageList.add(object);
        super.add(object);
    }

    public ChatArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
    }

    public int getCount() {
        return this.chatMessageList.size();
    }

    public ChatMessage getItem(int index) {
        return this.chatMessageList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage chatMessageObj = getItem(position);
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (chatMessageObj.right) {
            row = inflater.inflate(R.layout.right, parent, false);
        }else{
            row = inflater.inflate(R.layout.left, parent, false);
        }

        String currentDateTimeString = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.ITALIAN).format(new Date());
        dateStyle = (TextView) row.findViewById(R.id.date);
        dateStyle.setText(currentDateTimeString);

        chatText = (TextView) row.findViewById(R.id.msgr);

        chatText.setText(chatMessageObj.message);
        return row;
    }
}
