import java.util.Scanner;
import java.util.ArrayList;

public class modul2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("Pilih jenis pengguna:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    Admin admin = new Admin(scanner);
                    admin.menuAdmin();
                    break;
                case 2:
                    Mahasiswa mahasiswa = new Mahasiswa(scanner);
                    mahasiswa.menuMahasiswa();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 3);

        scanner.close();
    }
}

class Buku {
    private String id;
    private String judul;
    private String pencipta;
    private int stok;

    public Buku(String id, String judul, String pencipta, int stok) {
        this.id = id;
        this.judul = judul;
        this.pencipta = pencipta;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPencipta() {
        return pencipta;
    }

    public int getStok() {
        return stok;
    }

    // Method untuk mengurangi stok buku
    public void setStok(int stok) {
        this.stok = stok;
    }
}

class Mahasiswa {
    private Scanner scanner;

    private String nama;
    private String fakultas;
    private String programStudi;
    private String nim;  // Tambahkan atribut nim

    // Menambahkan beberapa contoh buku
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public Mahasiswa(Scanner scanner) {
        this.scanner = scanner;

        // Menambahkan beberapa contoh buku
        Buku buku1 = new Buku("001", "Java Programming", "John Doe", 10);
        Buku buku2 = new Buku("002", "Data Structures and Algorithms", "Jane Doe", 5);
        Buku buku3 = new Buku("003", "Introduction to Artificial Intelligence", "Bob Smith", 8);

        daftarBuku.add(buku1);
        daftarBuku.add(buku2);
        daftarBuku.add(buku3);
    }

    // Tambahkan metode getNim
    public String getNim() {
        return nim;
    }

    // Metode untuk menampilkan daftar buku
    public void tampilkanDaftarBuku() {
        System.out.println("Daftar Buku:");
        for (Buku buku : daftarBuku) {
            System.out.println("ID: " + buku.getId());
            System.out.println("Judul: " + buku.getJudul());
            System.out.println("Pencipta: " + buku.getPencipta());
            System.out.println("Stok: " + buku.getStok());
            System.out.println();
        }
    }

    // Method untuk meminjam buku
    public void pinjamBuku() {
        System.out.println("Masukkan ID Buku yang ingin dipinjam: ");
        String idBuku = scanner.nextLine();

        // Cari buku berdasarkan ID
        Buku bukuDipinjam = null;
        for (Buku buku : daftarBuku) {
            if (buku.getId().equals(idBuku)) {
                bukuDipinjam = buku;
                break;
            }
        }

        if (bukuDipinjam != null) {
            if (bukuDipinjam.getStok() > 0) {
                // Kurangi stok buku
                bukuDipinjam.setStok(bukuDipinjam.getStok() - 1);
                System.out.println("Buku berhasil dipinjam.");
            } else {
                System.out.println("Maaf, stok buku tidak mencukupi.");
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void logout() {
        System.out.println("Logout berhasil.");
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getFakultas() {
        return fakultas;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void menuMahasiswa() {
        int pilihanMahasiswa;
        do {
            System.out.println("Menu Mahasiswa:");
            System.out.println("1. Lihat Daftar Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Logout");
            System.out.print("Pilihan Anda: ");
            pilihanMahasiswa = scanner.nextInt();
            scanner.nextLine();

            switch (pilihanMahasiswa) {
                case 1:
                    tampilkanDaftarBuku();
                    break;
                case 2:
                    pinjamBuku();
                    break;
                case 3:
                    logout();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihanMahasiswa != 3);
    }
}

class Admin {
    private Scanner scanner;
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public Admin(Scanner scanner) {
        this.scanner = scanner;

        // Menambahkan beberapa mahasiswa contoh
        Mahasiswa mahasiswa1 = new Mahasiswa(scanner);
        mahasiswa1.setNama("Nayla Amanda");
        mahasiswa1.setNim("202310370311210");
        mahasiswa1.setFakultas("Teknik");
        mahasiswa1.setProgramStudi("Informatika");
        daftarMahasiswa.add(mahasiswa1);

        Mahasiswa mahasiswa2 = new Mahasiswa(scanner);
        mahasiswa2.setNama("Sabrina Ananda");
        mahasiswa2.setNim("202310370311206");
        mahasiswa2.setFakultas("Ilmu Komunikasi");
        mahasiswa2.setProgramStudi("Jurnalistik");
        daftarMahasiswa.add(mahasiswa2);
    }

    public void menuAdmin() {
        int pilihanAdmin;
        do {
            System.out.println("Menu Admin:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Daftar Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Pilihan Anda: ");
            pilihanAdmin = scanner.nextInt();
            scanner.nextLine();

            switch (pilihanAdmin) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihanAdmin != 3);
    }

    private void tambahMahasiswa() {
        System.out.println("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.println("Masukkan NIM Mahasiswa (harus 15 karakter): ");
        String nim = scanner.nextLine();
        System.out.println("Masukkan Fakultas Mahasiswa: ");
        String fakultas = scanner.nextLine();
        System.out.println("Masukkan Program Studi Mahasiswa: ");
        String programStudi = scanner.nextLine();

        if (nim.length() == 15) {
            Mahasiswa mahasiswa = new Mahasiswa(scanner);
            mahasiswa.setNama(nama);
            mahasiswa.setNim(nim);
            mahasiswa.setFakultas(fakultas);
            mahasiswa.setProgramStudi(programStudi);
            daftarMahasiswa.add(mahasiswa);

            System.out.println("Mahasiswa berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan mahasiswa. Panjang NIM harus 15 karakter.");
        }
    }

    private void tampilkanMahasiswa() {
        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println("Nama: " + mahasiswa.getNama());
            System.out.println("NIM: " + mahasiswa.getNim());
            System.out.println("Fakultas: " + mahasiswa.getFakultas());
            System.out.println("Program Studi: " + mahasiswa.getProgramStudi());
            System.out.println();
        }
    }
}