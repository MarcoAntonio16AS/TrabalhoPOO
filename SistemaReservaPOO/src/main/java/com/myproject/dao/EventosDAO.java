package com.myproject.dao;

import com.myproject.dao.ConnectionFactory;
import com.myproject.model.EventosReserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventosDAO {

    public void registrarEvento(
            EventosReserva evento
    ) {

        String sql =
                "INSERT INTO eventos_reserva " +
                        "(id_reserva, tipo_evento, descricao, data_evento) " +
                        "VALUES (?, ?, ?, ?)";

        try (
                Connection conn = ConnectionFactory.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(0, evento.getId_reserva());

            stmt.setString(1, evento.getTipo_evento());

            stmt.setString(2, evento.getDescricao());

            stmt.setTimestamp(
                    3,
                    java.sql.Timestamp.valueOf(
                            evento.getData_evento()
                    )
            );

            stmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao registrar evento: "
                            + e.getMessage()
            );
        }
    }

    public List<EventosReserva> listarEventos() {

        List<EventosReserva> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM eventos_reserva";

        try (
                Connection conn =
                        ConnectionFactory.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql);

                ResultSet rs =
                        stmt.executeQuery()
        ) {

            while(rs.next()) {

                EventosReserva evento =
                        new EventosReserva();

                evento.setId_evento(
                        rs.getInt("id_evento")
                );

                evento.setId_reserva(
                        rs.getInt("id_reserva")
                );

                evento.setTipo_evento(
                        rs.getString("tipo_evento")
                );

                evento.setDescricao(
                        rs.getString("descricao")
                );

                evento.setData_evento(
                        rs.getTimestamp(
                                "data_evento"
                        ).toLocalDateTime()
                );

                lista.add(evento);
            }

        } catch(SQLException e) {

            System.out.println(
                    "Erro ao listar eventos: "
                            + e.getMessage()
            );
        }

        return lista;
    }
}