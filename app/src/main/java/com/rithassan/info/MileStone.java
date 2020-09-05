package com.rithassan.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class MileStone extends Fragment {
    View view;
    ImageView man1,man2,man3,man4,man5,man6,man7,man8,man9;
    public MileStone() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_mile_stone, container, false);
        man1=(ImageView)view.findViewById(R.id.image1);
        man2=(ImageView)view.findViewById(R.id.image2);
        man3=(ImageView)view.findViewById(R.id.image3);
        man4=(ImageView)view.findViewById(R.id.image4);
        man5=(ImageView)view.findViewById(R.id.image5);
        man6=(ImageView)view.findViewById(R.id.image6);
        man7=(ImageView)view.findViewById(R.id.image7);
        man8=(ImageView)view.findViewById(R.id.image8);
        man9=(ImageView)view.findViewById(R.id.image9);

        Glide.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/55831640_107731510404133_6618276966543917056_n.jpg?_nc_cat=107&_nc_ht=scontent.fblr1-3.fna&oh=199bc1b765ec002ec0aa7b7a586e0247&oe=5D0B0218").into(man1);
        Glide.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55539216_107731413737476_683771996252667904_n.jpg?_nc_cat=104&_nc_ht=scontent.fblr1-4.fna&oh=2ecb1e6c39f9107c5f6c5e7d2dca2678&oe=5D0785BF").into(man2);
        Glide.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55448549_107731530404131_2791863647322767360_n.jpg?_nc_cat=108&_nc_ht=scontent.fblr1-4.fna&oh=d6953aaf00618ac90a2e0e6cd5514a13&oe=5D497E12").into(man3);
        Glide.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55535187_107731630404121_8092783202545958912_n.jpg?_nc_cat=101&_nc_ht=scontent.fblr1-4.fna&oh=3d6c187c6e44a0f273b7d74a740ac7b7&oe=5D504335").into(man4);
        Glide.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55485993_107731643737453_585551982593310720_n.jpg?_nc_cat=110&_nc_ht=scontent.fblr1-4.fna&oh=b3f0241b03ddb55e1e5b976791181ae0&oe=5D13D2F9").into(man5);
        Glide.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55826967_107731407070810_2388150783221694464_n.jpg?_nc_cat=105&_nc_ht=scontent.fblr1-4.fna&oh=efb57f3b5919b0a5a289b4c8027ed9a5&oe=5D179417").into(man6);
        Glide.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55764250_107731420404142_9164281752242356224_n.jpg?_nc_cat=101&_nc_ht=scontent.fblr1-4.fna&oh=d2bdc43a4b2a74e57fdc84d134b74be2&oe=5D4D4040").into(man7);
        Glide.with(getContext()).load("https://scontent.fblr1-3.fna.fbcdn.net/v/t1.0-9/53399800_107731627070788_6999845103820865536_n.jpg?_nc_cat=103&_nc_ht=scontent.fblr1-3.fna&oh=9abb82279265bd2f22baf361bf7216e6&oe=5D1946CA").into(man8);
        Glide.with(getContext()).load("https://scontent.fblr1-4.fna.fbcdn.net/v/t1.0-9/55845523_107731517070799_8218093726719803392_n.jpg?_nc_cat=108&_nc_ht=scontent.fblr1-4.fna&oh=d482224a5a346442fa1b7dafde462cbc&oe=5D118A22").into(man9);

        return view;
    }


}
