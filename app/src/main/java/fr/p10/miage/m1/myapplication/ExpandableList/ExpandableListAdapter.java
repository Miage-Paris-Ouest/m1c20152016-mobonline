package fr.p10.miage.m1.myapplication.ExpandableList;

import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

// TESTING CLICKABLE TEXTVIEW
import fr.p10.miage.m1.myapplication.Accueil;
import fr.p10.miage.m1.myapplication.HowToPages;
import fr.p10.miage.m1.myapplication.R;

public class ExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static final int HEADER = 0;
    public static final int CHILD = 1;
    private List<Item> data;
    private String myClassName;

    public ExpandableListAdapter(List<Item> data, String className) {
        this.data = data;
        this.myClassName = className;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int type) {

        View view = null;
        final Context context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;
        int subItemPaddingLeft = (int) (18 * dp);
        int subItemPaddingTopAndBottom = (int) (5 * dp);
        switch (type) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_header, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                final TextView itemTextView = new TextView(context);

                // TESTING CLICABLE TEXTVIEW
                itemTextView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Context context = parent.getContext();

                        Class<?> c = null;
                        String concatMyClassName = "fr.p10.miage.m1.myapplication."+myClassName+"Pages";
                        Log.w("GIRAFE", context + " : " + concatMyClassName);

                        try {
                            c= Class.forName(concatMyClassName);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                            Log.w("className ERROR", context + " : " + c);
                        }

                        if(myClassName.equalsIgnoreCase("Culture")){
                            for(Item item:data) {
                                if (item.link != null) {
                                    if (itemTextView.getText().equals(item.text)) {
                                        Log.w("CHARLIEEEE5", " : " + item.link);
                                        Uri uri = Uri.parse(item.link);
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        context.startActivity(intent);
                                    }
                                }
                            }
                        }else if(myClassName.equalsIgnoreCase("HowTo")){
                            Intent intent = new Intent(context,c)
                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("title_how_to",itemTextView.getText());
                            context.startActivity(intent);
                        }else if(myClassName.equalsIgnoreCase("Contact")){
                            Intent intent = new Intent(context,c)
                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("title_how_to",itemTextView.getText());
                            context.startActivity(intent);
                        }
                    }
                });

                itemTextView.setPadding(subItemPaddingLeft, subItemPaddingTopAndBottom, 0, subItemPaddingTopAndBottom);
                itemTextView.setTextColor(0x88000000);
                itemTextView.setLayoutParams(
                        new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                return new RecyclerView.ViewHolder(itemTextView) {
                };
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = data.get(position);
        switch (item.type) {
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = item;
                itemController.header_title.setText(item.text);
                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                }
                itemController.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<Item>();
                            int count = 0;
                            int pos = data.indexOf(itemController.refferalItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                        } else {
                            int pos = data.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD:
                TextView itemTextView = (TextView) holder.itemView;
                itemTextView.setText(data.get(position).text);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView header_title;
        public ImageView btn_expand_toggle;
        public Item refferalItem;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.header_title);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
        }
    }

    public static class Item {
        public int type;
        public String text;
        public String link;
        public List<Item> invisibleChildren;

        public Item() {
        }

        public Item(int type, String text) {
            this.type = type;
            this.text = text;
        }
        public Item(int type, String text, String link) {
            this.type = type;
            this.text = text;
            this.link = link;
        }
    }
}