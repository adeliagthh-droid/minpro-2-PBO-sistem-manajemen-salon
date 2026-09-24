/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistem_manajemen_salon_minpro;

/**
 *
 * @author HP VICTUS
 */
import java.util.ArrayList;
import java.util.Scanner;
import model.Layanan;
import model.LayananKecantikan;
import model.LayananRambut;
import model.Pelanggan;
import model.Reservasi;

public class Sistem_manajemen_salon_minpro {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private static ArrayList<Layanan> daftarLayanan = new ArrayList<>();
    private static ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
    private static int idPelangganBerikutnya = 6;
    private static int idLayananBerikutnya = 6;
    private static int idReservasiBerikutnya = 6;

    public static void main(String[] args) {
        isiDataAwal();

        int pilihan;

        do {
            System.out.println();
            System.out.println("SISTEM MANAJEMEN SALON");
            System.out.println("1. Kelola Pelanggan");
            System.out.println("2. Kelola Layanan");
            System.out.println("3. Kelola Reservasi");
            System.out.println("4. Keluar");
            pilihan = inputAngka("Pilih menu: ", 1, 4);

            switch (pilihan) {
                case 1:
                    menuPelanggan();
                    break;
                case 2:
                    menuLayanan();
                    break;
                case 3:
                    menuReservasi();
                    break;
                case 4:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
            }
        } while (pilihan != 4);
    }


    private static void isiDataAwal() {
        daftarPelanggan.add(new Pelanggan(1, "Ciaaw", "081234567890"));
        daftarPelanggan.add(new Pelanggan(2, "Mrow", "081298765432"));
        daftarPelanggan.add(new Pelanggan(3, "Chantip", "081345678901"));
        daftarPelanggan.add(new Pelanggan(4, "Casey", "081387654321"));
        daftarPelanggan.add(new Pelanggan(5, "Keity", "081456789013"));

        daftarLayanan.add(new LayananRambut(1, "Potong Rambut", 50000, "Pendek"));
        daftarLayanan.add(new LayananRambut(2, "Creambath", 100000, "Sedang"));
        daftarLayanan.add(new LayananRambut(3, "Smoothing Rambut", 350000, "Panjang"));
        daftarLayanan.add(new LayananKecantikan(4, "Facial", 150000, 60));
        daftarLayanan.add(new LayananKecantikan(5, "Manicure Pedicure", 120000, 90));

        daftarReservasi.add(new Reservasi(1, daftarPelanggan.get(0), daftarLayanan.get(0), "01-10-2026"));
        daftarReservasi.add(new Reservasi(2, daftarPelanggan.get(1), daftarLayanan.get(1), "02-10-2026"));
        daftarReservasi.add(new Reservasi(3, daftarPelanggan.get(2), daftarLayanan.get(2), "03-10-2026"));
        daftarReservasi.add(new Reservasi(4, daftarPelanggan.get(3), daftarLayanan.get(3), "04-10-2026"));
        daftarReservasi.add(new Reservasi(5, daftarPelanggan.get(4), daftarLayanan.get(4), "05-10-2026"));
    }

    private static void tampilkanSubMenu(String namaData) {
        System.out.println();
        System.out.println("MENU" + namaData.toUpperCase());
        System.out.println("1. Tambah " + namaData);
        System.out.println("2. Tampilkan " + namaData);
        System.out.println("3. Ubah " + namaData);
        System.out.println("4. Hapus " + namaData);
        System.out.println("5. Kembali");
    }

    private static void menuPelanggan() {
        int pilihan;

        do {
            tampilkanSubMenu("Pelanggan");
            pilihan = inputAngka("Pilih: ", 1, 5);

            switch (pilihan) {
                case 1:
                    tambahPelanggan();
                    break;
                case 2:
                    tampilkanPelanggan();
                    break;
                case 3:
                    ubahPelanggan();
                    break;
                case 4:
                    hapusPelanggan();
                    break;
            }
        } while (pilihan != 5);
    }

    private static void tambahPelanggan() {
        System.out.println("TAMBAH PELANGGAN");
        String nama = inputNama("Nama Pelanggan : ");
        String noTelepon = inputNoTelepon("No Telepon     : ");

        daftarPelanggan.add(new Pelanggan(idPelangganBerikutnya, nama, noTelepon));
        idPelangganBerikutnya++;
        System.out.println("yeayy Data Pelanggan sudah ditambahkan!");
    }

    private static void tampilkanPelanggan() {
        System.out.println("DAFTAR PELANGGAN");

        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
            return;
        }

        for (int i = 0; i < daftarPelanggan.size(); i++) {
            System.out.println(daftarPelanggan.get(i).getInfo());
            System.out.println("--------------------------------");
        }
    }

    private static void ubahPelanggan() {
        tampilkanPelanggan();

        if (daftarPelanggan.isEmpty()) {
            return;
        }

        int index = cariPelanggan(inputAngka("Masukkan ID Pelanggan yang ingin diubah: "));

        if (index == -1) {
            System.out.println("ID Pelanggan tidak ditemukan.");
            return;
        }

        Pelanggan pelanggan = daftarPelanggan.get(index);
        pelanggan.setNama(inputNama("Nama baru       : "));
        pelanggan.setNoTelepon(inputNoTelepon("No Telepon baru : "));
        System.out.println("yeayy Data Pelanggan sudah diubah!");
    }

    private static void hapusPelanggan() {
        tampilkanPelanggan();

        if (daftarPelanggan.isEmpty()) {
            return;
        }

        int index = cariPelanggan(inputAngka("Masukkan ID Pelanggan yang ingin dihapus: "));

        if (index == -1) {
            System.out.println("ID Pelanggan tidak ditemukan.");
            return;
        }

        if (inputKonfirmasi("Yakin ingin menghapus " + daftarPelanggan.get(index).getNama() + "?")) {
            daftarPelanggan.remove(index);
            System.out.println("yeayy Data Pelanggan sudah dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    private static int cariPelanggan(int id) {
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getIdPelanggan() == id) {
                return i;
            }
        }

        return -1;
    }


    private static void menuLayanan() {
        int pilihan;

        do {
            tampilkanSubMenu("Layanan");
            pilihan = inputAngka("Pilih: ", 1, 5);

            switch (pilihan) {
                case 1:
                    tambahLayanan();
                    break;
                case 2:
                    tampilkanLayanan();
                    break;
                case 3:
                    ubahLayanan();
                    break;
                case 4:
                    hapusLayanan();
                    break;
            }
        } while (pilihan != 5);
    }

    private static void tambahLayanan() {
        System.out.println("TAMBAH LAYANAN");
        System.out.println("Kategori: 1. Rambut  2. Kecantikan");
        int kategori = inputAngka("Pilih kategori : ", 1, 2);
        String nama = inputNama("Nama Layanan   : ");
        int harga = inputAngka("Harga (Rp)     : ", 10000, 5000000);

        if (kategori == 1) {
            System.out.println("Panjang rambut: 1. Pendek  2. Sedang  3. Panjang");
            int pilihanPanjang = inputAngka("Pilih panjang  : ", 1, 3);
            String panjangRambut = "Pendek";

            if (pilihanPanjang == 2) {
                panjangRambut = "Sedang";
            } else if (pilihanPanjang == 3) {
                panjangRambut = "Panjang";
            }

            daftarLayanan.add(new LayananRambut(idLayananBerikutnya, nama, harga, panjangRambut));
        } else {
            int durasi = inputAngka("Durasi (menit) : ", 15, 240);
            daftarLayanan.add(new LayananKecantikan(idLayananBerikutnya, nama, harga, durasi));
        }

        idLayananBerikutnya++;
        System.out.println("yeayy Data Layanan sudah ditambahkan!");
    }

    private static void tampilkanLayanan() {
        System.out.println("DAFTAR LAYANAN");

        if (daftarLayanan.isEmpty()) {
            System.out.println("Belum ada data layanan.");
            return;
        }

        for (int i = 0; i < daftarLayanan.size(); i++) {
            System.out.println(daftarLayanan.get(i).getInfo());
            System.out.println("--------------------------------");
        }
    }

    private static void ubahLayanan() {
        tampilkanLayanan();

        if (daftarLayanan.isEmpty()) {
            return;
        }

        int index = cariLayanan(inputAngka("Masukkan ID Layanan yang ingin diubah: "));

        if (index == -1) {
            System.out.println("ID Layanan tidak ditemukan.");
            return;
        }

        Layanan layanan = daftarLayanan.get(index);
        layanan.setNamaLayanan(inputNama("Nama Layanan baru : "));
        layanan.setHarga(inputAngka("Harga baru (Rp)   : ", 10000, 5000000));
        System.out.println("yeayy Data Layanan sudah diubah!");
    }

    private static void hapusLayanan() {
        tampilkanLayanan();

        if (daftarLayanan.isEmpty()) {
            return;
        }

        int index = cariLayanan(inputAngka("Masukkan ID Layanan yang ingin dihapus: "));

        if (index == -1) {
            System.out.println("ID Layanan tidak ditemukan.");
            return;
        }

        if (inputKonfirmasi("Yakin ingin menghapus " + daftarLayanan.get(index).getNamaLayanan() + "?")) {
            daftarLayanan.remove(index);
            System.out.println("yeayy Data Layanan sudah dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    private static int cariLayanan(int id) {
        for (int i = 0; i < daftarLayanan.size(); i++) {
            if (daftarLayanan.get(i).getIdLayanan() == id) {
                return i;
            }
        }

        return -1;
    }

    private static void menuReservasi() {
        int pilihan;

        do {
            tampilkanSubMenu("Reservasi");
            pilihan = inputAngka("Pilih: ", 1, 5);

            switch (pilihan) {
                case 1:
                    tambahReservasi();
                    break;
                case 2:
                    tampilkanReservasi();
                    break;
                case 3:
                    ubahReservasi();
                    break;
                case 4:
                    hapusReservasi();
                    break;
            }
        } while (pilihan != 5);
    }

    private static void tambahReservasi() {
        if (daftarPelanggan.isEmpty() || daftarLayanan.isEmpty()) {
            System.out.println("Data pelanggan/layanan masih kosong, tambahin dulu!");
            return;
        }

        System.out.println("TAMBAH RESERVASI");
        tampilkanPelanggan();
        int indexPelanggan = cariPelanggan(inputAngka("Masukkan ID Pelanggan: "));

        if (indexPelanggan == -1) {
            System.out.println("ID Pelanggan tidak ditemukan. Reservasi dibatalkan.");
            return;
        }

        tampilkanLayanan();
        int indexLayanan = cariLayanan(inputAngka("Masukkan ID Layanan: "));

        if (indexLayanan == -1) {
            System.out.println("ID Layanan tidak ditemukan. Reservasi dibatalkan.");
            return;
        }

        String tanggal = inputTanggal("Tanggal (dd-mm-yyyy): ");

        daftarReservasi.add(new Reservasi(idReservasiBerikutnya, daftarPelanggan.get(indexPelanggan), daftarLayanan.get(indexLayanan), tanggal));
        idReservasiBerikutnya++;
        System.out.println("yeayy Data Reservasi sudah ditambahkan!");
    }

    private static void tampilkanReservasi() {
        System.out.println("DAFTAR RESERVASI");

        if (daftarReservasi.isEmpty()) {
            System.out.println("Belum ada data reservasi.");
            return;
        }

        for (int i = 0; i < daftarReservasi.size(); i++) {
            System.out.println(daftarReservasi.get(i).getInfo());
            System.out.println("--------------------------------");
        }
    }

    private static void ubahReservasi() {
        tampilkanReservasi();

        if (daftarReservasi.isEmpty()) {
            return;
        }

        int index = cariReservasi(inputAngka("Masukkan ID Reservasi yang ingin diubah: "));

        if (index == -1) {
            System.out.println("ID Reservasi tidak ditemukan.");
            return;
        }

        Reservasi reservasi = daftarReservasi.get(index);
        System.out.println("Tanggal lama: " + reservasi.getTanggal());
        reservasi.setTanggal(inputTanggal("Tanggal baru (dd-mm-yyyy): "));
        System.out.println("yeayy Data Reservasi sudah diubah!");
    }

    private static void hapusReservasi() {
        tampilkanReservasi();

        if (daftarReservasi.isEmpty()) {
            return;
        }

        int index = cariReservasi(inputAngka("Masukkan ID Reservasi yang ingin dihapus: "));

        if (index == -1) {
            System.out.println("ID Reservasi tidak ditemukan.");
            return;
        }

        if (inputKonfirmasi("Yakin ingin menghapus reservasi ini?")) {
            daftarReservasi.remove(index);
            System.out.println("yeayy Data Reservasi sudah dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    private static int cariReservasi(int id) {
        for (int i = 0; i < daftarReservasi.size(); i++) {
            if (daftarReservasi.get(i).getIdReservasi() == id) {
                return i;
            }
        }

        return -1;
    }

    private static int inputAngka(String label) {
        while (true) {
            System.out.print(label);
            String teks = input.nextLine().trim();

            try {
                int angka = Integer.parseInt(teks);

                if (angka > 0) {
                    return angka;
                }

                System.out.println("Input harus lebih dari 0.");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    private static int inputAngka(String label, int min, int max) {
        while (true) {
            int angka = inputAngka(label);

            if (angka >= min && angka <= max) {
                return angka;
            }

            System.out.println("Input harus di antara " + min + " sampai " + max + ".");
        }
    }

    private static String inputNama(String label) {
        while (true) {
            System.out.print(label);
            String teks = input.nextLine().trim();

            if (teks.length() < 2) {
                System.out.println("Input minimal 2 huruf.");
            } else if (!hanyaHuruf(teks)) {
                System.out.println("Input hanya boleh berisi huruf dan spasi.");
            } else {
                return rapikanHuruf(teks);
            }
        }
    }

    private static String inputNoTelepon(String label) {
        while (true) {
            System.out.print(label);
            String teks = input.nextLine().trim();

            if (!hanyaAngka(teks)) {
                System.out.println("No telepon hanya boleh berisi angka.");
            } else if (!teks.startsWith("08")) {
                System.out.println("No telepon harus diawali 08.");
            } else if (teks.length() < 10 || teks.length() > 13) {
                System.out.println("No telepon harus 10 sampai 13 digit.");
            } else {
                return teks;
            }
        }
    }

    private static String inputTanggal(String label) {
        while (true) {
            System.out.print(label);
            String teks = input.nextLine().trim();

            if (tanggalValid(teks)) {
                return teks;
            }

            System.out.println("Format tanggal harus dd-mm-yyyy, contoh 25-09-2026.");
        }
    }

    private static boolean inputKonfirmasi(String label) {
        while (true) {
            System.out.print(label + " (y/n): ");
            String teks = input.nextLine().trim().toLowerCase();

            if (teks.equals("y")) {
                return true;
            } else if (teks.equals("n")) {
                return false;
            }

            System.out.println("Ketik y atau n.");
        }
    }

    private static boolean hanyaHuruf(String teks) {
        for (int i = 0; i < teks.length(); i++) {
            char karakter = teks.charAt(i);

            if (!Character.isLetter(karakter) && karakter != ' ') {
                return false;
            }
        }

        return true;
    }

    private static boolean hanyaAngka(String teks) {
        if (teks.isEmpty()) {
            return false;
        }

        for (int i = 0; i < teks.length(); i++) {
            if (!Character.isDigit(teks.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static String rapikanHuruf(String teks) {
        String[] kata = teks.toLowerCase().split("\\s+");
        String hasil = "";

        for (int i = 0; i < kata.length; i++) {
            hasil += kata[i].substring(0, 1).toUpperCase() + kata[i].substring(1);

            if (i < kata.length - 1) {
                hasil += " ";
            }
        }

        return hasil;
    }

    private static boolean tanggalValid(String teks) {
        String[] bagian = teks.split("-");

        if (bagian.length != 3) {
            return false;
        }

        if (bagian[0].length() != 2 || bagian[1].length() != 2 || bagian[2].length() != 4) {
            return false;
        }

        if (!hanyaAngka(bagian[0]) || !hanyaAngka(bagian[1]) || !hanyaAngka(bagian[2])) {
            return false;
        }

        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);

        return hari >= 1 && hari <= 31 && bulan >= 1 && bulan <= 12 && tahun >= 2026; 
    }       
        }
