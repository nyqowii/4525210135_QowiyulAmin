# Analisis Invariant Mahasiswa

1. NIM harus ada dan tidak boleh kosong atau null.
2. Nama boleh diisi, tetapi identitas mahasiswa tetap terikat pada NIM yang diberikan saat objek dibuat.
3. NIM tidak berubah setelah objek dibuat karena atributnya bersifat final.
4. Nilai tugas, UTS, dan UAS harus masing-masing berada dalam rentang 0 sampai 100.
5. Nilai akhir dihitung dengan bobot tetap: 30% tugas + 30% UTS + 40% UAS.
6. Nilai akhir dan huruf mutu selalu dihitung berdasarkan nilai yang valid.
7. Tidak diperbolehkan membuat setNim() karena NIM merupakan invariant yang harus konsisten sepanjang masa objek.
