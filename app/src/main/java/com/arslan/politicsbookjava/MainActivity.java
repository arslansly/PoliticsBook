package com.arslan.politicsbookjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.arslan.politicsbookjava.databinding.ActivityDetailsBinding;
import com.arslan.politicsbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    ArrayList<Politics> politicsArrayList;
    private ActivityMainBinding binding;
    //static Politics chosenPolitics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        politicsArrayList = new ArrayList<>();

        //Data

        Politics kemal = new Politics("Kemal Kılıçdaroğlu","Tunceli'nin Nazımiye ilçesinde doğan Kemal Kılıçdaroğlu, ilk ve ortaöğrenimini Erciş, Tunceli, Genç, Elazığ gibi Anadolu'nun çeşitli yerlerinde yaptı. Yükseköğrenimini yapmak için girdiği Ankara İktisadi ve Ticari İlimler Akademisi'nden (şimdiki adıyla Gazi Üniversitesi İktisadi ve İdari Bilimler Fakültesi) 1971'de mezun oldu.\n" +
                "\n" +
                "Lisans öğrenimini tamamladığı 1971 yılında, girdiği hesap uzman yardımcılığı sınavının ardından Maliye Bakanlığı'nda göreve başladı. Daha sonra hesap uzmanı olan Kılıçdaroğlu, bir yıl Fransa'da kaldı. Hesap uzmanlığını 1983'e kadar sürdürdü ve aynı yıl Gelirler Genel Müdürlüğü'ne atandı. Burada önce daire başkanı olarak görev aldı, daha sonra aynı kurumun genel müdür yardımcılığını yaptı.\n" +
                "\n" +
                "Kemal Kılıçdaroğlu 1991 yılında Bağ-Kur'a atandı. Burada genel müdürlük yapan Kılıçdaroğlu, 1992 yılında da Sosyal Sigortalar Kurumu Genel Müdürlüğü'ne geçti. Daha sonra kısa bir süre Türkiye Cumhuriyeti Çalışma ve Sosyal Güvenlik Bakanlığı'nda müsteşar yardımcısı olarak görev yaptı. 1994 yılında Ekonomik Trend dergisi tarafından \"Yılın Bürokratı\" seçildi. Kemal Kılıçdaroğlu, 1999'un Ocak ayında kendi isteğiyle Sosyal Sigortalar Kurumu Genel Müdürlüğü'nden emekli oldu.\n" +
                "\n" +
                "Sekizinci Beş Yıllık Kalkınma Planı çalışmalarında Kayıtdışı Ekonomi Özel İhtisas Komisyonu'na başkanlık eden Kılıçdaroğlu, Hacettepe Üniversitesi'nde de bir süre ders verdi. Daha sonra Türkiye İş Bankası'nda yönetim kurulu üyesi olarak görev yaptı.\n" +
                "\n" +
                "11 Ocak 1999'da SSK Genel Müdürlüğü'nden ayrılan Kemal Kılıçdaroğlu'nun, Demokratik Sol Parti'den 18 Nisan 1999'daki genel ya da yerel seçimlerde aday olmak için istifa ettiği dönemin gazetelerinde belirtildi. 18 Nisan 1999 genel ve yerel seçimlerinde aday gösterilmedi.\n" +
                "\n" +
                "Türkiye Büyük Millet Meclisi 22. dönem için yapılan 3 Kasım 2002 Milletvekili Genel Seçimleri'yle Cumhuriyet Halk Partisi İstanbul milletvekili olarak Meclis'e girdi.22 Temmuz 2007 Milletvekili Genel Seçimleri'nde de İstanbul'dan 23. dönem milletvekili seçildi.\n" +
                "\n" +
                "Cumhuriyet Halk Partisi Genel Başkanı Kemal Kılıçdaroğlu'nun Ankara'dan İstanbul'a kadar adalet talebiyle yürüdü. Kılıçdaroğlu yürüyüş kararını, Berberoğlu'na yirmi beş yıl hapis cezası ve tutuklama kararı verilmesi sonrasında aldı. Yürüyüş, 15 Haziran 2017'de Ankara'da Güven Park'ta başlamış ve 9 Temmuz 2017'de Maltepe'de sonlandırılmıştır. 420 kilometrelik yolu 25 günde yürüyen Kılıçdaroğlu, yürüyüşün sonunda Maltepe'de bir miting de düzenledi.\n" +
                "\n" +
                "27. dönem CHP İzmir 2. bölge milletvekili adayı oldu.",R.drawable.kemal);
        Politics sinan = new Politics("Sinan Oğan","1 Eylül 1967 Iğdır doğumludur.\n" +
                "\n" +
                "Sinan Oğan, stratejik araştırmacı ve 24. dönem MHP Iğdır milletvekilidir.\n" +
                "\n" +
                "Azeri kökenli olan Sinan Oğan, Marmara Üniversitesi İİBF mezunu olup yüksek lisans çalışmasını aynı üniversitede tamamladı. Moskova Devlet Uluslararası İlişkiler Üniversitesi'nde (MGİMO) doktora çalışmasını tamamlamıştır.\n" +
                "\n" +
                "İleri düzeyde Rusça ve akademik düzeyde İngilizce bilen Sinan Oğan, Marmara Üniversitesi Türkiyat Araştırmaları Enstitüsünde araştırma görevlisi, Azerbaycan Devlet Ekonomi Üniversitesinde öğretim görevlisi ve Dekan Yardımcısı olarak görev yaptı.\n" +
                "\n" +
                "TİKA Azerbaycan Temsilcisi de olan Sinan Oğan'a Azerbaycan Cumhurbaşkanı tarafından “Devlet Nişanı” ile taltif edildi.\n" +
                "\n" +
                "Sinan Oğan, aynı zamanda Avrasya Stratejik Araştırmalar Merkezi (ASAM) Rusya Ukrayna Araştırmaları Masası Başkanlığı yaptı.\n" +
                "\n" +
                "Sinan Oğan, TÜRKSAM'ı kurdu ve Başkanlığını yaptı. Valdai Formu Üyesi olan Sinan Oğan'ın yayınlanmış 3 kitabı ve 500'den fazla makalesi bulunmaktadır.\n" +
                "\n" +
                "Milliyet Gazetesi “Sosyal Bilimler”, Marmara Üniversitesi “Akademik Üstün Başarı” ve Ekoavrasya Derneği “Türk Dünyasına Hizmet” ödüllerinin sahibi olan Sinan Oğan, “İnterpress Media Takip Merkezi” tarafından 2010 yılında televizyon ekranlarında en çok tartışılan konu ve en çok ekranda yer alan isimler üzerine yapılan bir çalışmada 131 haberle, Türkiye'de televizyon ekranlarında en fazla boy gösteren isimleri arasında yer aldı.\n" +
                "\n" +
                "Sinan Oğan, 12 Haziran 2011 genel seçimlerinde Milliyetçi Hareket Partisi'nden Iğdır milletvekili seçilmiştir.\n" +
                "\n" +
                "Türkiye-Arnavutluk ve Türkiye-Nijer Parlamentolararası Dostluk Grupları üyesi ve Türkiye-Azerbaycan Parlamentolararası Dostluk Grubu Genel Sekreteridir.\n" +
                "\n" +
                "Haziran 2015 Türkiye genel seçimleri'nde partisinden aday gösterilmedi",R.drawable.sinan);
        Politics meral = new Politics("Meral Akşener","Selanik'ten Kocaeli'ye göç eden Balkan Türkü bir ailenin kızı olan Meral Akşener 18 Temmuz 1956 tarihinde Tahir Ömer Bey ve Sıddıka Hanım'ın çocuğu olarak Kocaeli'nin İzmit ilçesine bağlı Gündoğdu köyünde doğdu. 1974 yılında Bursa Kız Öğretmen Lisesi'ni tamamlamasının ardından 1979 yılında İstanbul Üniversitesi Edebiyat Fakültesi Tarih Bölümü'nden mezun oldu.\n" +
                "\n" +
                "1979 ve 1982 yılları arasında öğretmen olarak çalışan Akşener, 1982 yılında Yıldız Teknik Üniversitesi Kocaeli Mühendislik Fakültesi'nde araştırma görevlisi oldu. Marmara Üniversitesi Sosyal Bilimler Enstitüsü'nde doktora ve yüksek lisans yaptı. Kocaeli Üniversitesi'nde İnkılap Tarihi Bölüm Başkanlığı görevinde bulundu. Zübeyde Hanım Şehit Aileleri Vakfı'nın kuruluşunu gerçekleştirdi ve başkanlığını yaptı.\n" +
                "\n" +
                "İçişleri Bakanlığı\n" +
                "1995 yılında Doğru Yol Partisi (DYP) Kadın Kolları Başkanı olan Meral Akşener, ilk defa 1995 Türkiye genel seçimlerinde DYP Kocaeli milletvekili olarak meclise girdi. Necmettin Erbakan başkanlığında 28 Haziran 1996 tarihinde Refah Partisi (RP) ve DYP koalisyonunun oluşturduğu 54. Türkiye Hükûmeti'nden 3 Kasım 1996 tarihinde Susurluk kazası sonrası İçişleri Bakanlığı görevinden istifa eden Mehmet Ağar'ın yerine İçişleri Bakanlığı görevini üstlenerek Türkiye tarihindeki ilk kadın İçişleri Bakanı oldu. 28 Şubat süreci'nin yaşanması ile 54. Türkiye Hükümeti'nin dağılmasının ardından görev süresi 30 Haziran 1997 tarihinde son buldu. 1999 Türkiye genel seçimlerinde DYP İstanbul milletvekili olarak tekrar meclise girdi. 2002 Türkiye genel seçimlerinde ise DYP %9,54 oy alarak baraj altında kaldı.\n" +
                "\n" +
                "AKP'nin kuruluş aşamasında yer alması\n" +
                "4 Temmuz 2001 tarihinde Doğru Yol Partisi'nden istifa ederek Fazilet Partisi'nden kopan Abdullah Gül ile Recep Tayyip Erdoğan'ın önderliğini yaptığı 'yenilikçi' kanat olarak adlandırılan oluşuma katıldığını Abdullah Gül ve arkadaşlarının çalışma ofisi olarak kullandıkları Politik Araştırmalar Merkezi’nde basın toplantısıyla ilan etti.Yeni parti için çalışma yaparken oğlunun da parti adı için çalışma yürüttüğünü söyledi. Ancak bir süre sonra \"Milli Görüş çizgisini sürdürüyorlar\" diyerek hayal kırıklığı yaşadığını belirterek yenilikçi hareketten ayrılıp 3 Kasım 2001 tarihinde Milliyetçi Hareket Partisi'ne katıldı.\n" +
                "\n" +
                "Milliyetçi Hareket Partisi\n" +
                "2001 yılında Milliyetçi Hareket Partisi'ne (MHP) katılan Akşener, 2007 Türkiye genel seçimlerinde MHP İstanbul milletvekili olarak meclise girdi. Bu süre içerisinde MHP genel başkanı Devlet Bahçeli'ye siyasi işler alanında başdanışmanlık yaptı.2004 yerel seçimlerinde MHP'den İstanbul Büyükşehir belediye başkan adayı oldu.En son 1968 yılında Cumhuriyet Halk Partisi'den (CHP) Türkiye Büyük Millet Meclisi Başkanvekili seçilen Muş milletvekili Hayriye Ayşe Nermin Neftçi'den sonra 10 Ağustos 2007 tarihinde Güldal Mumcu ile beraber TBMM başkanvekilliği görevine seçildi. TBMM'de Türkiye-Çin Parlamentolararası Dostluk Grubu üyeliği yaptı.2011 ve Haziran 2015 genel seçimlerinde tekrar MHP İstanbul milletvekili olarak tekrar meclise girdi. Fakat Kasım 2015 Türkiye genel seçimlerinde partisinden milletvekili adayı gösterilmedi.\n" +
                "\n" +
                "MHP genel başkanlık adaylığı ve ihracı\n" +
                "Kasım 2015 genel seçimlerinde MHP'nin oy kaybederek mecliste temsil edilen dördüncü parti olması üzerine ay sonunda yapmış olduğu basın toplantısında kurultay talebinde bulunmuş ve \"Üzerime düşen her görevi yapmaya hazırım.\" demiştir. Mahkeme kararıyla yapılacak olan MHP olağanüstü kongresi için Meral Akşener genel başkan adayı oldu.Olağanüstü Kongre tarihi olarak 15 Mayıs'ın belirlendiğini açıklandı. MHP Genel Merkezi ise bu kararı tanımadığını bildirdi. Eylül 2016 tarihinden partiden ihraç edildi.Meral Akşener, 19 Haziran 2016 tarinde Ankara Nöbetçi Asliye Hukuk Mahkemesine başvurarak, partiden ihraç kararına ihtiyati tedbir konulmasını istedi. MHP'nin ihraç kararına açmış olduğu iptal davası, 15 Aralık 2016 tarihinde Ankara 6. Asliye Hukuk Mahkemesi tarafından reddedildi ve bu kararla partiden ihracı kesinleşti.\n" +
                "\n" +
                "Akşener’in kuracağı yeni partinin ismi “İyi Parti” sloganı ise “Türkiye iyi olacak” oldu. Akşener İçişleri Bakanlığı’na dilekçesini verdikten sonra yeni partisini Ankara’da Nâzım Hikmet Kültür Merkezi’nde ‘Türkiye İyi Olacak’ sloganıyla 25 Ekim 2017 Tarihinde kamuoyuna açıkladı.\n" +
                "\n" +
                "Özel yaşamı\n" +
                "Meral Akşener, 1980 yılından beri Makine Mühendisi Tuncer Akşener ile evlidir ve Fatih Akşener (d. 1984) adında bir oğlu vardır.",R.drawable.meral);
        Politics tayyip = new Politics("Recep Tayyip Erdoğan","Aslen Rizeli olan Recep Tayyip Erdoğan, 26 Şubat 1954'te İstanbul'da dünyaya geldi. 1965 yılında Kasımpaşa Piyale İlkokulu'ndan, 1973 yılında ise İstanbul İmam Hatip Lisesi'nden mezun oldu. Fark dersleri sınavını vererek Eyüp Lisesi'nden de diploma aldı. Üniversiteyi Marmara Üniversitesi İktisadî ve Ticarî Bilimler Fakültesi'nde okudu ve bu okuldan 1981 yılında mezun oldu. Futbolla 1969-1982 yılları arasında amatör olarak ilgilendi. Aynı zamanda bu yıllar, genç bir idealist olarak memleket meseleleri ve toplumsal sorunlarla ilgilenerek aktif politikaya adım attı.\n" +
                "\n" +
                "Lise ve üniversite yıllarında Millî Türk Talebe Birliği öğrenci kollarında aktif görev alan Recep Tayyip Erdoğan, 1976 yılında MSP Beyoğlu Gençlik Kolu Başkanlığı'na ve aynı yıl MSP İstanbul Gençlik Kolları Başkanlığı'na seçildi. 1980 yılına kadar bu görevlerini sürdüren Erdoğan, siyasi partilerin kapatıldığı 12 Eylül döneminde, özel sektörde bir süre müşavirlik ve üst düzey yöneticilik yaptı.\n" +
                "\n" +
                "1983 yılında kurulan Refah Partisi ile fiilî siyasete geri döndü ve 1984 yılında Refah Partisi Beyoğlu İlçe Başkanı, 1985 yılında ise Refah Partisi İstanbul İl Başkanı, Refah Partisi MKYK üyesi oldu. İstanbul İl Başkanlığı görevi sırasında diğer siyasi partiler için de model olan yeni bir örgütsel yapı geliştiren Erdoğan, bu dönemde özellikle kadınların ve gençlerin siyasete katılımını artırmaya yönelik çalışmalar yaptı. Bu yapılanma, mensubu bulunduğu Refah Partisi'ne 1989 Beyoğlu yerel seçimlerinde büyük bir başarı kazandırırken, yurt genelinde de parti çalışmaları için örnek teşkil etti.\n" +
                "\n" +
                "27 Mart 1994 yerel seçimlerinde İstanbul Büyükşehir Belediye Başkanı seçilen Recep Tayyip Erdoğan, İstanbul'un kronikleşmiş sorunlarına doğru teşhis ve çözümler üretti. 12 Aralık 1997'de Siirt'te halka hitaben yaptığı konuşma sırasında, Millî Eğitim Bakanlığı tarafından öğretmenlere tavsiye edilen ve bir devlet kuruluşu tarafından yayınlanan bir kitaptaki şiiri okuduğu için hapis cezasına mahkûm edildi ve İstanbul Büyükşehir Belediye Başkanlığı görevine son verildi.\n" +
                "\n" +
                "14 Ağustos 2001'de arkadaşlarıyla birlikte Adalet ve Kalkınma Partisi'ni (AK Parti) kurdu ve Kurucular Kurulu tarafından AK Parti'nin Kurucu Genel Başkanı seçildi. Milletin teveccüh ve güveni AK Parti'yi daha kuruluşunun ilk yılında Türkiye'nin en geniş halk desteğine sahip siyasî hareketi hâline getirdi ve 2002 yılı genel seçimlerinde üçte ikiye yakın parlamento çoğunluğuyla (363 milletvekili) tek başına iktidara taşıdı.\n" +
                "\n" +
                "Hakkında ki mahkeme kararı nedeniyle 3 Kasım 2002 seçimlerinde milletvekili adayı olamayan Erdoğan, yapılan yasal düzenlemeyle 9 Mart 2003'te Siirt ili milletvekili yenileme seçimine katıldı. Bu seçimde oyların yüzde 85'ini alan Erdoğan, 22. Dönem Siirt Milletvekili olarak parlamentoya girdi.\n" +
                "\n" +
                "15 Mart 2003 tarihinde Başbakanlık görevini üstlendi, aydınlık ve sürekli kalkınan bir Türkiye idealiyle, hayatî öneme sahip birçok reform paketini kısa süre içinde uygulamaya koydu. Bütün olumlu gelişmeler, bazı yabancı gözlemciler ve Batılı liderler tarafından \"Sessiz Devrim\" olarak adlandırıldı.\n" +
                "\n" +
                "Recep Tayyip Erdoğan, Avrupa Birliği'ne giriş sürecinde ülke tarihinin dönüm noktası olarak nitelenen başarılı girişimlerine ek olarak, Kıbrıs sorununun kalıcı çözüme kavuşturulması ve dünyanın çeşitli ülkeleriyle verimli ilişkiler geliştirilmesi konularında önemli adımlar attı. Türkiye'yi bir merkez ülke hâline getirdi. 22 Temmuz 2007 genel seçimlerinde %46,6 oy alarak büyük bir zafer kazanan AK Parti’nin Genel Başkanı olarak Türkiye Cumhuriyeti’nin 60. Hükûmeti’ni kurdu ve tekrar güvenoyu aldı. 12 Haziran 2011 seçimlerinden de daha büyük bir zaferle çıktı ve % 49,8 oy alarak 61. Hükûmeti kurdu.\n" +
                "\n" +
                "10 Ağustos 2014 Pazar günü, Türk siyasi tarihinde ilk kez doğrudan halkın oylarıyla ve ilk turda 12. Cumhurbaşkanı seçildi. 16 Nisan 2017 tarihindeki halk oylamasında kabul edilen Anayasa değişikliği ile Cumhurbaşkanının partili olabilmesinin önünün açılmasının ardından Recep Tayyip Erdoğan, 21 Mayıs 2017 tarihinde gerçekleştirilen 3. Olağanüstü Büyük Kongrede, kurucusu olduğu AK Parti'nin Genel Başkanlığına yeniden seçildi.\n" +
                "\n" +
                "24 Haziran 2018 Pazar günü yapılan Cumhurbaşkanlığı seçimlerinde %52.59 oy oranıyla yeniden Cumhurbaşkanı seçildi. 16 Nisan 2017’de kabul edilen Anayasa değişikliği ile hayata geçirilen Cumhurbaşkanlığı Hükûmet Sistemi’nin ilk Cumhurbaşkanı olarak 9 Temmuz 2018 tarihinde yemin ederek görevine başladı.\n" +
                "\n" +
                "Recep Tayyip Erdoğan, evli ve 4 çocuk babasıdır.\n",R.drawable.tayyip);


        politicsArrayList.add(kemal);
        politicsArrayList.add(sinan);
        politicsArrayList.add(meral);
        politicsArrayList.add(tayyip);

        // Not Efficient
        //Bitmap
        Bitmap tayyipBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tayyip);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PoliticsAdapter politicsAdapter = new PoliticsAdapter(politicsArrayList);
        binding.recyclerView.setAdapter(politicsAdapter);
        /*

        //Adapter
        //Listview
        //mapping
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                politicsArrayList.stream().map(politics -> politics.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(MainActivity.this,politicsArrayList.get(position).name,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("politics",politicsArrayList.get(position));
                startActivity(intent);
            }
        });
        */


    }
}