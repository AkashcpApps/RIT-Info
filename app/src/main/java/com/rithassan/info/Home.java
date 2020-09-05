package com.rithassan.info;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class Home extends Fragment {
View view1;
ProgressBar progressBar1,progressBar2;
TextView tv;
public static int sample=0;

    CarouselView carouselView,carouselView1;

    String[] sampleImages = {"https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55613169_112529363257681_3012286780612280320_o.jpg?_nc_cat=100&_nc_ht=scontent.fblr4-2.fna&oh=b812877e98ffe99b2fb093a6f038f552&oe=5D4CD50C",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55451660_112528996591051_4594714021365547008_o.jpg?_nc_cat=110&_nc_ht=scontent.fblr4-1.fna&oh=945ea7a6892883f6cb4dd40a2789ec52&oe=5D4A32BA",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/56248105_112528993257718_2738394495648268288_o.jpg?_nc_cat=109&_nc_ht=scontent.fblr4-1.fna&oh=86f60313a4fea97ac436064943f01725&oe=5D44D99E",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55869435_112528983257719_601945365956001792_o.jpg?_nc_cat=101&_nc_ht=scontent.fblr4-1.fna&oh=ac2474849168999aac67effa62ed37aa&oe=5D0F0F16",
    "https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/56229350_112529089924375_8656081112742756352_n.jpg?_nc_cat=107&_nc_ht=scontent.fblr4-2.fna&oh=e6e15fff4a6d842f31de9c91235be1ef&oe=5D3EEBD7",
    "https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55576919_112529083257709_6825594389381775360_n.jpg?_nc_cat=107&_nc_ht=scontent.fblr4-2.fna&oh=0c03d25871dc2858e837e2f4bd87e067&oe=5D4392A6",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/55576407_112529426591008_3424294072670486528_o.jpg?_nc_cat=101&_nc_ht=scontent.fblr4-1.fna&oh=79a68b2a67bba566ff2d1d7bc5b3059b&oe=5D417EE5",
    "https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55952447_112529099924374_6719319916178046976_n.jpg?_nc_cat=106&_nc_ht=scontent.fblr4-2.fna&oh=8cbbf39191c9bf3a37eccd393285e5d3&oe=5D40AF2C",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/56556975_112529129924371_3185001490192269312_n.jpg?_nc_cat=102&_nc_ht=scontent.fblr4-1.fna&oh=ce11aff13ef5e5d9c584d57d77fdca31&oe=5D07EF32",
    "https://scontent.fblr4-1.fna.fbcdn.net/v/t1.0-9/56389506_112529153257702_8768186317583417344_n.jpg?_nc_cat=101&_nc_ht=scontent.fblr4-1.fna&oh=573dd67537c69aa0f5de3a61c471ca02&oe=5D4FB7D3",
    "https://scontent.fblr4-2.fna.fbcdn.net/v/t1.0-9/55613128_112529403257677_4173240445293297664_n.jpg?_nc_cat=111&_nc_ht=scontent.fblr4-2.fna&oh=33d7e8bd15dabb01d28f014cc9e4e1df&oe=5D4EBD9B"};

String[] quotasImages={"https://scontent.fixe1-1.fna.fbcdn.net/v/t1.0-9/56732712_118600195983931_1753799042908815360_o.jpg?_nc_cat=102&_nc_ht=scontent.fixe1-1.fna&oh=031c9833cf56bb86d2392ae9d990aba0&oe=5D4CFE0E"
,"https://scontent.fixe1-1.fna.fbcdn.net/v/t1.0-9/56980825_118600179317266_1626427037512105984_o.jpg?_nc_cat=106&_nc_ht=scontent.fixe1-1.fna&oh=1dd920189e376a237c45e734d2bc2498&oe=5D3AEC89"
,"https://scontent.fixe1-1.fna.fbcdn.net/v/t1.0-9/56412474_118600205983930_1681739576265146368_o.jpg?_nc_cat=111&_nc_ht=scontent.fixe1-1.fna&oh=e199b8da341cca4ca5a878a60a982b08&oe=5D334F20"
,"https://scontent.fixe1-1.fna.fbcdn.net/v/t1.0-9/56567358_118600235983927_5259768262379438080_o.jpg?_nc_cat=109&_nc_ht=scontent.fixe1-1.fna&oh=4285cb3f2601bc4e4d86e91ffd237add&oe=5D3BFF3A"
        ,"https://scontent.fixe1-1.fna.fbcdn.net/v/t1.0-9/56490488_118600259317258_5264238756398891008_o.jpg?_nc_cat=106&_nc_ht=scontent.fixe1-1.fna&oh=8cfda832f29592c2040702300063e92f&oe=5D439960"};

ImageView fb,tweet,web,insta,you;
    public static String FACEBOOK_URL = "https://www.facebook.com/rit.hassan.73";
    public static String FACEBOOK_PAGE_ID = "101085159976351";
    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view1= inflater.inflate(R.layout.fragment_home, container, false);



        carouselView = (CarouselView)view1. findViewById(R.id.carouselView);
        carouselView1=(CarouselView)view1.findViewById(R.id.carouselViewquoites) ;
       carouselView1.setPageCount(quotasImages.length);
       carouselView1.setImageListener(quitesListener);

        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);


        fb=(ImageView)view1.findViewById(R.id.facebook);
        tweet=(ImageView)view1.findViewById(R.id.twitter);
        web=(ImageView)view1.findViewById(R.id.google_plus);
        insta=(ImageView)view1.findViewById(R.id.instagram);
        you=(ImageView)view1.findViewById(R.id.youtube);
        fb.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.from_bottom));
        insta.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.from_bottom));

        web.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.from_bottom));
        tweet.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.from_bottom));
        you.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.from_bottom));
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.rithassan.org/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(getActivity());
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/rajeevinstitute");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/rajeevinstitute")));
                }
            }
        });
        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=null;
                try {
                    intent =new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.youtube");
                    intent.setData(Uri.parse("https://www.youtube.com/channel/UC9zh3smlsNSmB6_E5n82z8Q"));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.youtube.com/channel/UC9zh3smlsNSmB6_E5n82z8Q"));
                    startActivity(intent);
                }
            }
        });
        tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                try {
                    intent.setPackage("com.twitter.android");
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=rajeev_of"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://twitter.com/rajeev_of"));
                    startActivity(intent);
                }
            }
        });







        return view1;
    }
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

           Glide.with(getContext()).load(sampleImages[position]).into(imageView);

        }
    };

    ImageListener quitesListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            Glide.with(getContext()).load(quotasImages[position]).into(imageView);

        }
    };



}




