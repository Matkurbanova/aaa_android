package kg.itrun.android.aaa.data;

import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import kg.itrun.android.aaa.R;

public class Category extends AppCompatActivity implements View.OnClickListener, Serializable {

    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    private String icon;

    private String name;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

        }
    }
}
