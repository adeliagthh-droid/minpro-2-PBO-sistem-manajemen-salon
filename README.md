# Sistem Manajemen Salon

**Nama:** ADELIA GITHA NAVEEZHA HERMAWAN

**NIM:** 2509116110

## 1. Deskripsi Program

Sistem Manajemen Salon merupakan program aplikasi berbasis konsol (Command Line Interface) yang dibuat menggunakan bahasa pemrograman Java dengan menerapkan prinsip Pemrograman Berorientasi Objek. Program ini merupakan pengembangan lanjutan dari Mini Project 1.

Sebuah salon kecantikan setiap harinya melayani banyak pelanggan dengan berbagai jenis perawatan, mulai dari potong rambut, creambath, smoothing, facial, hingga manicure pedicure. Apabila seluruh data tersebut dicatat secara manual, pengelola salon akan kesulitan ketika ingin mencari, mengubah, maupun menghapus data tertentu. Oleh karena itu program ini dibuat agar pencatatan data salon menjadi lebih teratur dan lebih cepat.

Terdapat tiga data utama yang dikelola oleh program ini. Data pertama adalah data pelanggan yang berisi ID pelanggan, nama, dan nomor telepon. Data kedua adalah data layanan yang berisi ID layanan, nama layanan, kategori, dan harga. Data ketiga adalah data reservasi yang berisi ID reservasi, pelanggan yang memesan, layanan yang dipesan, dan tanggal reservasi.

Pada ketiga data tersebut, pengguna dapat melakukan empat operasi pengelolaan data, yaitu menambah data baru, menampilkan seluruh data, mengubah data yang sudah ada, dan menghapus data. Seluruh data disimpan menggunakan ArrayList sehingga jumlahnya dapat bertambah maupun berkurang selama program dijalankan.

## 2. Pengembangan dari Mini Project 1

Pada Mini Project 2 ini terdapat beberapa pengembangan dibandingkan versi sebelumnya.

Pengembangan pertama adalah penerapan inheritance. Pada versi sebelumnya seluruh class berdiri sendiri, sedangkan pada versi ini class Layanan dijadikan super-class yang diturunkan menjadi dua sub-class, yaitu LayananRambut dan LayananKecantikan.

Pengembangan kedua adalah penerapan polymorphism, baik dalam bentuk method overriding maupun method overloading.

Pengembangan ketiga adalah penerapan validasi input. Pada versi sebelumnya program akan berhenti secara tiba-tiba apabila pengguna memasukkan huruf pada bagian yang meminta angka. Pada versi ini seluruh masukan diperiksa terlebih dahulu sehingga program tidak pernah berhenti secara paksa.

Pengembangan keempat adalah perapian penulisan kode. Nama package kini seluruhnya menggunakan huruf kecil, penulisan spasi dan baris kosong dibuat seragam, serta seluruh class yang ada benar-benar digunakan oleh program.

## 3. Struktur Program

Program ini terdiri dari enam class yang dibagi ke dalam dua package.

Package pertama adalah **com.mycompany.sistem_manajemen_salon** yang berisi class utama bernama Sistem_Manajemen_Salon. Class inilah yang memuat seluruh jalannya program, mulai dari pengisian data awal, tampilan menu utama, seluruh proses tambah, tampil, ubah, dan hapus untuk ketiga data, sampai method-method validasi input. Seluruh class lain dipanggil dari class ini.

Package kedua adalah **model** yang berisi lima class sebagai cetak biru data, yaitu Pelanggan, Layanan, LayananRambut, LayananKecantikan, dan Reservasi. Class-class pada package ini hanya berisi atribut, constructor, serta method getter dan setter, tanpa berisi logika menu sama sekali.

<img width="400" alt="WhatsApp Image 2026-09-24 at 20 08 01" src="https://github.com/user-attachments/assets/f3f91080-e55b-4228-a45c-1f80b818b0ae" />


## 4. Penerapan Inheritance

### 4.1 Hierarki Class

Relasi inheritance pada program ini terdapat pada class Layanan. Class Layanan berperan sebagai super-class atau class induk, sedangkan class LayananRambut dan LayananKecantikan berperan sebagai sub-class atau class turunan. Hubungan ini dapat dibaca sebagai layanan rambut adalah sebuah layanan, dan layanan kecantikan juga merupakan sebuah layanan.

Class Layanan menyimpan data yang dimiliki oleh semua jenis layanan salon, yaitu ID layanan, nama layanan, dan harga. Class LayananRambut mewarisi seluruh data tersebut lalu menambahkan atribut panjang rambut, karena tarif perawatan rambut di salon umumnya dibedakan berdasarkan panjang rambut pelanggan. Class LayananKecantikan juga mewarisi data yang sama lalu menambahkan atribut durasi dalam satuan menit, karena perawatan kecantikan seperti facial biasanya dihitung berdasarkan lama pengerjaan.

Sementara itu class Pelanggan dan class Reservasi tidak memiliki relasi inheritance. Class Reservasi terhubung dengan class Pelanggan dan class Layanan dengan cara menyimpan objek dari kedua class tersebut sebagai atributnya.

### 4.2 Letak Penerapan pada Super-class Layanan
<img width="400" alt="image" src="https://github.com/user-attachments/assets/2eeef208-a138-4be3-a105-b1e1e6dd1260" />

Class Layanan memiliki tiga atribut, yaitu idLayanan, namaLayanan, dan harga. Class ini juga memiliki method getKategori dan getInfo yang nantinya akan ditimpa oleh kedua sub-class.

### 4.3 Letak Penerapan pada Sub-class LayananRambut

<img width="400" alt="image" src="https://github.com/user-attachments/assets/6bc7c821-947e-43eb-a8c9-3ac2c3110530" />

Penerapan inheritance terlihat pada dua bagian. Bagian pertama adalah kata kunci **extends Layanan** pada baris deklarasi class, yang menandakan bahwa class ini merupakan turunan dari class Layanan. Dengan kata kunci ini, seluruh method milik class Layanan seperti getNamaLayanan, getHarga, setNamaLayanan, dan setHarga otomatis dimiliki juga oleh class LayananRambut tanpa perlu ditulis ulang.

Bagian kedua adalah pemanggilan **super(idLayanan, namaLayanan, harga)** di dalam constructor. Kata kunci super berfungsi memanggil constructor milik class induk. Hal ini wajib dilakukan karena atribut pada class Layanan bersifat private sehingga tidak dapat diisi langsung oleh class turunannya. Setelah constructor induk selesai, barulah atribut khusus milik sub-class, yaitu panjangRambut, diisi.

### 4.4 Letak Penerapan pada Sub-class LayananKecantikan

<img width="400" alt="image" src="https://github.com/user-attachments/assets/0a380224-54a7-4ca5-a7c8-a66e5cb758ad" />

Class LayananKecantikan disusun dengan cara yang sama, yaitu menggunakan extends dan super. Perbedaannya hanya terletak pada atribut tambahan yang dimilikinya, yaitu durasiMenit.

### 4.5 Alasan Inheritance Harus Diterapkan

Alasan pertama adalah untuk menghindari penulisan kode yang sama berulang kali. Apabila tidak menggunakan inheritance, class LayananRambut dan LayananKecantikan harus sama-sama menuliskan atribut ID, nama layanan, dan harga beserta seluruh getter dan setter-nya. Artinya kode yang sama persis ditulis dua kali di dua tempat berbeda.

Alasan kedua adalah agar program mudah dikembangkan. Apabila suatu saat salon menambah jenis layanan baru, misalnya perawatan kuku, class barunya cukup mewarisi class Layanan lalu menambahkan atribut khususnya saja.

Alasan ketiga adalah agar seluruh jenis layanan dapat disimpan dalam satu ArrayList yang sama. Karena LayananRambut dan LayananKecantikan sama-sama merupakan turunan dari Layanan, keduanya dapat dimasukkan ke dalam ArrayList bertipe Layanan tanpa perlu membuat dua daftar terpisah. Hal ini membuat proses menampilkan, mengubah, dan menghapus data layanan cukup ditulis satu kali saja.

### 4.6 Letak Pembuatan Objek Sub-class

<img width="400" alt="image" src="https://github.com/user-attachments/assets/95bcf8bc-b218-486f-a9b2-3987e07eb2a6" />

Pada method tambahLayanan di class utama, program menanyakan kategori layanan terlebih dahulu kepada pengguna. Apabila pengguna memilih kategori rambut, program membuat objek LayananRambut. Apabila memilih kategori kecantikan, program membuat objek LayananKecantikan. Kedua objek tersebut kemudian dimasukkan ke dalam ArrayList yang sama.

## 5. Penerapan Polymorphism

### 5.1 Method Overriding

Method overriding adalah keadaan ketika sub-class menuliskan ulang method yang sudah ada pada super-class dengan isi yang berbeda. Pada program ini terdapat dua method yang di-override, dan keduanya ditandai dengan anotasi @Override.

Method pertama adalah **getKategori**. Pada class Layanan method ini mengembalikan teks Umum, pada class LayananRambut dikembalikan menjadi Rambut, dan pada class LayananKecantikan dikembalikan menjadi Kecantikan.

Method kedua adalah **getInfo**. Pada kedua sub-class, method ini memanggil super.getInfo terlebih dahulu untuk mengambil keterangan umum dari class induk, kemudian menambahkan keterangan khususnya sendiri. Pada LayananRambut ditambahkan baris panjang rambut, sedangkan pada LayananKecantikan ditambahkan baris durasi.

Letak penerapannya dapat dilihat pada screenshot class LayananRambut dan LayananKecantikan di bagian 4.3 dan 4.4, yaitu pada dua method yang diberi anotasi @Override.

**Alasan method overriding harus diterapkan:**

Alasan pertama adalah karena setiap jenis layanan memiliki keterangan yang berbeda. Layanan rambut perlu menampilkan panjang rambut, sedangkan layanan kecantikan perlu menampilkan durasi. Apabila method getInfo tidak di-override, keterangan khusus tersebut tidak akan pernah muncul karena class induk tidak mengetahui adanya atribut tambahan pada class turunannya.

Alasan kedua adalah agar kode penampil data tetap sederhana. Tanpa overriding, program harus memeriksa satu per satu jenis setiap data menggunakan percabangan sebelum menampilkannya. Dengan overriding, program cukup memanggil getInfo dan Java secara otomatis menjalankan versi method milik class yang sesuai.

Alasan ketiga adalah agar keterangan yang sama tidak ditulis ulang. Karena kedua sub-class memanggil super.getInfo terlebih dahulu, bagian ID, nama layanan, dan harga cukup ditulis satu kali di class induk.

### 5.2 Bukti Hasil Method Overriding

<img width="400" alt="image" src="https://github.com/user-attachments/assets/7ffabb5c-505a-4036-913b-002c05ee0609" />

Screenshot di atas merupakan bukti bahwa overriding benar-benar bekerja. Seluruh data ditampilkan menggunakan satu perulangan yang sama dan satu pemanggilan method getInfo yang sama, namun hasilnya berbeda-beda sesuai jenis datanya. Data Potong Rambut, Creambath, dan Smoothing Rambut menampilkan kategori Rambut beserta baris panjang rambut, sedangkan data Facial dan Manicure Pedicure menampilkan kategori Kecantikan beserta baris durasi.

### 5.3 Method Overloading

Method overloading adalah keadaan ketika terdapat dua method atau lebih dengan nama yang sama namun jumlah atau jenis parameternya berbeda.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/0d9d59e1-2236-4bd0-98eb-5d1b0cf05c65" />

Pada program ini method **inputAngka** ditulis dua kali. Bentuk pertama hanya menerima satu parameter berupa teks pertanyaan, dan digunakan ketika program hanya butuh memastikan masukan berupa angka yang lebih dari nol, misalnya saat meminta ID data yang ingin diubah atau dihapus.

Bentuk kedua menerima tiga parameter, yaitu teks pertanyaan, nilai minimal, dan nilai maksimal. Bentuk ini digunakan ketika masukan harus berada pada rentang tertentu, misalnya saat memilih menu yang hanya boleh diisi 1 sampai 4, atau saat memasukkan durasi layanan yang hanya boleh 15 sampai 240 menit. Di dalamnya, bentuk kedua memanggil bentuk pertama terlebih dahulu, baru kemudian memeriksa rentang nilainya.

**Alasan method overloading harus diterapkan:**

Alasan pertama adalah agar nama method tetap mudah diingat. Kedua method tersebut sama-sama bertugas meminta angka dari pengguna, sehingga lebih masuk akal apabila keduanya diberi nama yang sama daripada dibedakan menjadi nama seperti inputAngkaBiasa dan inputAngkaRentang.

Alasan kedua adalah agar pemanggilannya menjadi fleksibel. Ketika program hanya butuh angka bebas, cukup panggil bentuk yang pendek. Ketika program butuh angka pada rentang tertentu, panggil bentuk yang panjang. Java secara otomatis memilih method mana yang dijalankan berdasarkan jumlah parameter yang diberikan.

Alasan ketiga adalah agar pemeriksaan angka tidak ditulis dua kali, karena bentuk kedua cukup memanggil bentuk pertama untuk urusan memeriksa apakah masukan benar-benar berupa angka.

## 6. Penerapan Access Modifier dan Encapsulation

### 6.1 Letak Penerapan

(screenshot class Pelanggan)

Seluruh atribut pada class model dideklarasikan dengan access modifier **private**, seperti terlihat pada class Pelanggan di atas. Dengan demikian atribut tersebut tidak dapat diakses maupun diubah secara langsung dari class utama. Pembacaan dan pengubahan nilainya hanya dapat dilakukan melalui method getter dan setter yang bersifat **public**. Penerapan inilah yang disebut encapsulation.

(screenshot method ubahPelanggan)

Screenshot di atas menunjukkan bagaimana encapsulation digunakan dari class utama. Program tidak mengubah atribut secara langsung, melainkan memanggil method setNama dan setNoTelepon milik objek Pelanggan.

Pada class utama, method-method pembantu seperti validasi input dan pencarian data juga dideklarasikan private, karena method tersebut hanya digunakan di dalam class itu sendiri.

### 6.2 Alasan Encapsulation Harus Diterapkan

Alasan pertama adalah untuk melindungi data dari perubahan yang tidak sesuai. Apabila atribut dibuat public, siapa pun dapat mengubah isinya secara langsung dari luar class tanpa melewati pemeriksaan apa pun. Dengan setter, pengubahan nilai selalu melewati jalur yang sudah ditentukan.

Alasan kedua adalah agar data yang masuk tetap seragam. Nama pelanggan yang diubah melalui menu selalu melewati method validasi terlebih dahulu, sehingga tidak mungkin ada nama yang berisi angka atau simbol.

Alasan ketiga adalah agar perubahan di kemudian hari lebih mudah. Apabila suatu saat aturan penyimpanan nomor telepon diubah, cukup method setter-nya saja yang diperbaiki, tanpa perlu mengubah kode di seluruh bagian program.

## 7. Penerapan Validasi Input

### 7.1 Letak Penerapan

(screenshot method validasi input)

Seluruh method validasi dikumpulkan pada bagian bawah class utama, di bawah komentar VALIDASI INPUT, agar mudah dicari. Setiap method bekerja dengan cara yang sama, yaitu menampilkan pertanyaan, membaca masukan pengguna, lalu memeriksanya. Apabila masukan tidak sesuai, program menampilkan pesan kesalahan dan mengulang pertanyaan tersebut sampai masukan yang diberikan benar.

Validasi angka dilakukan oleh method inputAngka. Masukan dibaca sebagai teks terlebih dahulu, kemudian diubah menjadi angka di dalam blok try catch.

Validasi nama dilakukan oleh method inputNama. Nama harus terdiri dari minimal dua huruf dan hanya boleh berisi huruf beserta spasi. Selain diperiksa, nama juga dirapikan secara otomatis sehingga huruf awal setiap kata menjadi huruf besar dan spasi berlebih dihilangkan.

Validasi nomor telepon dilakukan oleh method inputNoTelepon. Nomor telepon hanya boleh berisi angka, harus diawali angka nol delapan, dan panjangnya harus antara sepuluh sampai tiga belas digit.

Validasi tanggal dilakukan oleh method inputTanggal. Tanggal harus ditulis dengan format dua digit hari, dua digit bulan, dan empat digit tahun yang dipisahkan tanda hubung.

Selain itu terdapat method inputKonfirmasi yang digunakan pada proses hapus, dan hanya menerima jawaban y atau n.

### 7.2 Alasan Validasi Input Harus Diterapkan

Alasan pertama adalah agar program tidak berhenti secara paksa. Pada Mini Project 1, memasukkan huruf pada bagian yang meminta angka akan membuat program langsung berhenti dengan pesan error yang panjang. Dengan validasi, kesalahan tersebut ditangani dan pengguna cukup diminta mengulang.

Alasan kedua adalah agar data yang tersimpan seragam. Tanpa validasi, nama bisa saja tersimpan dengan huruf kecil semua atau mengandung angka, dan nomor telepon bisa berisi teks sembarangan.

Alasan ketiga adalah agar data yang tersimpan masuk akal. Harga layanan tidak mungkin bernilai nol atau negatif, durasi perawatan tidak mungkin ribuan menit, dan bulan pada tanggal tidak mungkin lebih dari dua belas.

Alasan keempat adalah agar data tidak terhapus karena kesalahan pengguna. Konfirmasi sebelum menghapus membuat pengguna masih punya kesempatan membatalkan.

### 7.3 Bukti Hasil Validasi Input

(screenshot percobaan input salah)

Pengujian dilakukan dengan sengaja memasukkan data yang keliru, seperti huruf pada bagian yang meminta angka, angka di luar pilihan menu, nomor telepon yang tidak diawali nol delapan, serta tanggal dengan format yang salah. Program menampilkan pesan kesalahan sesuai jenis kesalahannya dan meminta masukan ulang tanpa berhenti secara paksa.

## 8. Dummy Data

(screenshot method isiDataAwal)

Program telah diisi dengan data awal sejak pertama kali dijalankan, yaitu lima data pelanggan, lima data layanan, dan lima data reservasi. Pengisian data ini dilakukan oleh method isiDataAwal yang dipanggil paling awal di dalam method main.

Data layanan awal sengaja dibuat mencakup kedua sub-class, yaitu tiga layanan rambut dan dua layanan kecantikan, agar hasil penerapan inheritance dan overriding langsung terlihat ketika fitur tampilkan dijalankan.

Alasan dummy data diterapkan adalah agar fitur tampilkan, ubah, dan hapus dapat langsung diuji tanpa harus menambahkan data terlebih dahulu, sehingga pengujian program menjadi lebih cepat.

## 9. Alur Program

Ketika program dijalankan, program pertama-tama mengisi data awal ke dalam ArrayList, kemudian menampilkan Menu Utama yang berisi pilihan Kelola Pelanggan, Kelola Layanan, Kelola Reservasi, dan Keluar.

Setelah pengguna memilih salah satu menu, program menampilkan sub menu yang berisi pilihan Tambah, Tampilkan, Ubah, Hapus, dan Kembali. Setiap masukan yang diberikan pengguna diperiksa terlebih dahulu oleh method validasi sebelum diproses. Setelah satu proses selesai, sub menu ditampilkan kembali sampai pengguna memilih Kembali untuk kembali ke Menu Utama.

Proses tersebut terus berulang selama pengguna belum memilih menu Keluar. Apabila pengguna memilih Keluar, program menampilkan pesan penutup dan berhenti.

## 10. Dokumentasi Program Dijalankan

Bagian ini menampilkan hasil pengujian program melalui jendela Output pada Apache NetBeans. Pengujian dilakukan secara berurutan mengikuti alur pemakaian yang wajar, yaitu menambahkan data baru terlebih dahulu, menampilkan daftarnya untuk memastikan data benar-benar tersimpan, mengubah data tersebut, lalu menghapusnya.

### 10.1 Menu Utama

Ketika program dijalankan, program terlebih dahulu mengisi data awal, kemudian menampilkan Menu Utama yang terdiri dari empat pilihan. Menu Utama dibungkus menggunakan perulangan do-while sehingga setelah satu proses selesai, menu ditampilkan kembali secara otomatis dan pengguna dapat melakukan beberapa pekerjaan sekaligus tanpa menjalankan ulang program.

(screenshot menu utama)

### 10.2 Tambah Pelanggan

Pengguna memasukkan nama pelanggan dan nomor telepon secara berurutan. Berbeda dengan versi sebelumnya, pengguna tidak perlu lagi mengetik ID karena ID dibuat otomatis oleh program agar tidak terjadi ID ganda yang dapat membuat proses ubah dan hapus salah sasaran. Nama yang dimasukkan juga dirapikan otomatis huruf besar kecilnya.

(screenshot tambah pelanggan)

### 10.3 Tampilkan Pelanggan

Sistem menampilkan seluruh data pelanggan, meliputi ID, nama, dan nomor telepon. Penelusuran dilakukan dari data pertama sampai terakhir sehingga tidak ada data yang terlewat. Pada tampilan ini terlihat lima data awal beserta data yang baru ditambahkan, yang membuktikan bahwa proses penambahan benar-benar tersimpan.

(screenshot tampilkan pelanggan)

### 10.4 Ubah Pelanggan

Program menampilkan daftar pelanggan terlebih dahulu, kemudian meminta ID yang ingin diubah. Apabila data ditemukan, pengguna memasukkan nama dan nomor telepon baru yang disimpan melalui method setter. ID tidak ikut diubah karena berfungsi sebagai identitas. Apabila ID tidak terdaftar, program menampilkan pesan dan tidak mengubah data apa pun.

(screenshot ubah pelanggan)

### 10.5 Hapus Pelanggan

Sebelum data dihapus, program menampilkan konfirmasi beserta nama pelanggan yang akan dihapus. Konfirmasi ini hanya menerima jawaban y atau n. Apabila dijawab n, penghapusan dibatalkan dan data tetap aman.

(screenshot hapus pelanggan)

### 10.6 Tambah Layanan

Program meminta kategori layanan terlebih dahulu. Apabila memilih kategori rambut, program menanyakan panjang rambut. Apabila memilih kategori kecantikan, program menanyakan durasi pengerjaan. Dari pilihan inilah program menentukan objek sub-class mana yang dibuat.

(screenshot tambah layanan)

### 10.7 Ubah dan Hapus Layanan

Pada proses ubah, pengguna dapat mengganti nama layanan dan harganya, misalnya ketika salon melakukan penyesuaian tarif. Pada proses hapus, program meminta konfirmasi terlebih dahulu seperti pada data pelanggan.

(screenshot ubah layanan)

### 10.8 Tambah Reservasi

Program memeriksa terlebih dahulu apakah daftar pelanggan atau layanan masih kosong, karena reservasi tidak mungkin dibuat tanpa keduanya. Setelah itu program menampilkan daftar pelanggan dan daftar layanan agar pengguna tinggal memilih ID yang tersedia, lalu meminta tanggal reservasi.

(screenshot tambah reservasi)

### 10.9 Tampilkan Reservasi

Sistem menampilkan seluruh data reservasi beserta nama pelanggan, nama layanan, kategori, harga, dan tanggal. Nama pelanggan dan nama layanan diambil langsung dari objek yang tersimpan di dalam reservasi, dan kategorinya diambil melalui method getKategori yang sudah di-override, sehingga hasil polymorphism juga terlihat pada menu ini.

(screenshot tampilkan reservasi)

### 10.10 Ubah dan Hapus Reservasi

Pada proses ubah, data yang dapat diubah hanya tanggalnya saja, karena mengganti pelanggan atau layanan pada dasarnya berarti membuat pemesanan yang berbeda. Pada proses hapus, yang dihapus hanya data reservasinya, sedangkan data pelanggan dan layanan tetap tersimpan.

(screenshot ubah reservasi)

### 10.11 Keluar Program

Apabila pengguna memilih menu Keluar, program menampilkan pesan penutup. Kondisi pada perulangan do-while menjadi tidak terpenuhi sehingga perulangan berhenti dan program selesai dijalankan.

(screenshot keluar program)

## 11. Kesimpulan

Program Sistem Manajemen Salon pada Mini Project 2 ini telah menerapkan seluruh ketentuan yang diminta. Inheritance diterapkan melalui satu super-class bernama Layanan yang diturunkan menjadi dua sub-class, yaitu LayananRambut dan LayananKecantikan, menggunakan kata kunci extends dan super, dengan tujuan agar atribut yang sama tidak ditulis berulang dan seluruh jenis layanan dapat disimpan dalam satu daftar.

Polymorphism diterapkan dalam dua bentuk. Method overriding diterapkan pada getKategori dan getInfo agar setiap jenis layanan dapat menampilkan keterangan khususnya sendiri walaupun dipanggil dengan cara yang sama. Method overloading diterapkan pada inputAngka agar satu nama method dapat dipakai untuk dua kebutuhan berbeda.

Validasi input diterapkan pada seluruh masukan pengguna sehingga program tidak pernah berhenti secara paksa dan data yang tersimpan menjadi seragam. Access modifier dan encapsulation diterapkan dengan menjadikan seluruh atribut bersifat private yang hanya dapat diakses melalui getter dan setter. Program juga telah diisi dengan data awal sehingga fitur pembacaan data dapat langsung dijalankan.

Berdasarkan hasil pengujian yang telah didokumentasikan, seluruh fitur tambah, tampilkan, ubah, dan hapus pada menu Pelanggan, Layanan, dan Reservasi telah berjalan sesuai dengan yang diharapkan.
