/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/
/* 
    Created on : Dec 12, 2020, 11:08:16 AM
    Author     : Riett
*/

$(document).ready(function() {
   /**
   * Customize "Tabel Barang" DataTable
   **/
    $('#barang-table').DataTable({
        columnDefs: [
          {
            targets: [-1],
            orderable: false
          },
          {
            targets: [0, -1],
            className: "dt-head-center dt-body-center"
          }
        ]
    });
    
    /**
   * Customize "Tabel Barang" DataTable
   **/
    $('#transaksi-table').DataTable({
        columnDefs: [
          {
            targets: [-1],
            orderable: false
          },
          {
            targets: [0, -1],
            className: "dt-head-center dt-body-center"
          }
        ]
    });

   /**
   * Customize "Tabel Pengguna" DataTable
   **/
    $('#pengguna-table').DataTable({
        columnDefs: [
          {
            targets: [-1],
            orderable: false
          },
          {
            targets: [0, -1],
            className: "dt-head-center dt-body-center"
          }
        ]
    });
});