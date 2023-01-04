SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `friends` (
  `id_user1` int(11) NOT NULL,
  `id_user2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `MESSAGES` (
  `id_user1` int(11) NOT NULL,
  `id_user2` int(11) NOT NULL,
  `message` text NOT NULL,
  `DATE` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `friends`
  ADD KEY `id_user1` (`id_user1`),
  ADD KEY `id_user2` (`id_user2`);

ALTER TABLE `MESSAGES`
  ADD KEY `id_user1` (`id_user1`),
  ADD KEY `id_user2` (`id_user2`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `friends`
  ADD CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`id_user1`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`id_user2`) REFERENCES `users` (`id`);

ALTER TABLE `MESSAGES`
  ADD CONSTRAINT `MESSAGES_ibfk_1` FOREIGN KEY (`id_user1`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `MESSAGES_ibfk_2` FOREIGN KEY (`id_user2`) REFERENCES `users` (`id`);
COMMIT;

