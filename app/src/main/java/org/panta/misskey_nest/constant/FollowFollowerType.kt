package org.panta.misskey_nest.constant

enum class FollowFollowerType {
    FOLLOWING, FOLLOWER;
    companion object{
        fun getTypeFromOrdinal(ordinal: Int): FollowFollowerType{
            return when(ordinal){
                FOLLOWER.ordinal -> FOLLOWER
                FOLLOWING.ordinal -> FOLLOWING
                else -> FOLLOWING
            }
        }
    }
}