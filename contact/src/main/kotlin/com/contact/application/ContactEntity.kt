package com.contact.application

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Table(name = "Contact")
@Entity(name = "Contact")
data class ContactEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    @NotNull
    @Column(name = "name")
    val name: String? = null,
    @NotNull
    @Column(name = "mobile")
    val mobile: String? = null
)

fun ContactEntity.toDTO() =
    Contact(
        id = id,
        name = name,
        mobile = mobile
    )

fun Contact.toEntity() =
    ContactEntity(
        id = id,
        name = name,
        mobile = mobile
    )