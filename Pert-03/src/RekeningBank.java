/**
 * Sesi 3 — constructor berdelegasi, anggota statis, dan konstanta.
 *
 * Invariant:
 *   1. saldo tidak pernah negatif
 *   2. nomor rekening tidak berubah setelah objek dibuat
 *   3. setoran dan penarikan selalu bernilai positif
 */
public class RekeningBank {
    public static final double BUNGA_TAHUNAN = 0.025;
    public static final double BIAYA_ADMINISTRASI = 5000;
    public static final double BATAS_PENARIKAN_SEKALI = 5000000;

    private static int jumlahRekening = 0;


    private final String nomor;
    private final String pemilik;
    private double saldo;

    /**
     * Constructor ringkas.
     * TODO 3: DELEGASIKAN ke constructor lengkap dengan this(...).
     *         Jangan menyalin validasi ke sini.
     */
    public RekeningBank(String nomor, String pemilik) {
        this(nomor, pemilik, 0);
    }

    /** Constructor lengkap — SATU-SATUNYA tempat validasi berada. */
    public RekeningBank(String nomor, String pemilik, double saldoAwal) {
        if (nomor == null || nomor.isBlank() || saldoAwal < 0) {
            throw new IllegalArgumentException();
        }

        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldoAwal;

        jumlahRekening++;
    }
    

    public void setor(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException();
        }
        saldo += jumlah;
    }

    public void tarik(double jumlah) {
        if (jumlah <= 0 || jumlah > saldo || jumlah > BATAS_PENARIKAN_SEKALI) {
            throw new IllegalArgumentException();
        }
        saldo -= jumlah;
    }

    /** TODO 8: kurangi saldo sebesar biaya administrasi, tetapi jangan sampai negatif. */
    public void potongBiayaAdmin() {
        saldo = Math.max(0, saldo - BIAYA_ADMINISTRASI);
    }

    /** TODO 9: method statis — kembalikan jumlah rekening yang pernah dibuat. */
    public static int getJumlahRekening() {
        return jumlahRekening;
    }

    /**
     * TODO 10: method statis utilitas — hitung bunga setahun dari pokok.
     *          Perhatikan: method ini tidak membaca keadaan objek mana pun.
     *          Itulah alasan ia pantas menjadi static.
     */
    public static double bungaSetahun(double pokok) {
        return pokok * BUNGA_TAHUNAN;
    }

    public double getSaldo()  { return saldo; }
    public String getNomor()  { return nomor; }

    @Override
    public String toString() {
        return String.format("Rekening[%s] %-14s Rp%,.2f", nomor, pemilik, saldo);
    }
}
