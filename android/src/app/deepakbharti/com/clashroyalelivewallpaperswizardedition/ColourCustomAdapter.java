package app.deepakbharti.com.clashroyalelivewallpaperswizardedition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColourCustomAdapter extends BaseAdapter {

    Context context;
    String[] coloursNames;
    LayoutInflater inflter;

    public ColourCustomAdapter(Context context, String[] coloursname) {
        this.context = context;
        this.coloursNames = coloursname;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return coloursNames.length;
    }

    @Override
    public Object getItem(int i) {
        return coloursNames[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.colour_spinner_item,null);
        TextView name = (TextView) view.findViewById(R.id.colourname);
        name.setText(coloursNames[i]);
        return view;
    }


}
