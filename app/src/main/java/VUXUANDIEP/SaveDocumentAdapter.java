package VUXUANDIEP;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import VUXUANDIEP.DocumentObject;
import VUXUANDIEP.DocumentAdapter;

import com.example.anassert.Login;
import com.example.anassert.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class SaveDocumentAdapter extends RecyclerView.Adapter< SaveDocumentAdapter .PersonViewHolder> {

    private Context context;
    private ArrayList<SaveDocumentObject> list;
    private ImageButton cancelButton;
    private Button ok_btn;

    public  SaveDocumentAdapter(Context context, ArrayList<SaveDocumentObject> list){
        this.context= context;
        this.list = list;
    }
    public void setFilteredList(ArrayList<SaveDocumentObject> filteredList){
        this.list=filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View studentView =
                inflater.inflate(R.layout.item_savedocument, parent, false);
        PersonViewHolder viewHolder = new PersonViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        final SaveDocumentObject savedocumentObject = list.get(position);
        if(savedocumentObject  == null){
            return;
        }
        holder.txtSubject.setText("Học Phần:"+list.get(position).getMonHoc());
        holder.txtSubjectId.setText("Mã Học Phần:"+list.get(position).getMaHP());
        holder.txtDate.setText(""+list.get(position).getNgayLuu());
        holder.txtUrl.setText(""+list.get(position).getURL());
        holder.txtUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDocumentAdapter.this.onClick(savedocumentObject);
            }
        });
        holder.btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                SaveDocumentAdapter.this.onClick(savedocumentObject);
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Chức năng đang trong quá trình phát triển", Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View alertCustomDialog = LayoutInflater.from(context).inflate(R.layout.custom_dialog,null);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

                alertDialog.setView(alertCustomDialog);
                cancelButton = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
                ok_btn = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);
                final  AlertDialog dialog = alertDialog.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                ok_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                        Toast.makeText(context, "Cảm ơn bạn đã phản hồi.Báo cáo đã được gửi đến nhà phát triển.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
    private void onClick( SaveDocumentObject savedocumentObject){
        Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse(savedocumentObject.getURL()));
        context.startActivity(url);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  class PersonViewHolder extends RecyclerView.ViewHolder{
        TextView txtSubject,txtSubjectId,txtUrl,txtDate;
        ImageView btnOpen, btnDelete,btnReport;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSubject = itemView.findViewById(R.id.txtSubject);
            txtSubjectId = itemView.findViewById(R.id.txtSubjectId);
            txtUrl = itemView.findViewById(R.id.txtUrl);
            txtDate = itemView.findViewById(R.id.txtDate);
            btnDelete = itemView.findViewById(R.id.btnSave);
            btnOpen = itemView.findViewById(R.id.btnOpen);
            btnReport = itemView.findViewById(R.id.btnReport);
        }
    }

}
